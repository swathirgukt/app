package com.example.sql

import com.example.sql.repository.AirSearchRequestAnalyticRepository
import groovy.util.logging.Slf4j
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner)
@SpringBootTest
@Slf4j
class SqlApplicationTests {

    @Autowired
    AirSearchRequestAnalyticRepository airSearchRequestAnalyticRepository
    String datePattern = "yyyy-MM-dd"
    @Test
    void contextLoads() {
    }

    @Test
    void getSearchAnalytics() {
        try {

            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream("searches.txt"), "UTF-8")
            BufferedWriter bufWriter = new BufferedWriter(writer)

            String datePattern = "yyyy-MM-dd"

            Date startDate = Date.parse(datePattern, "2018-07-01")
            log.warn("--start date:" + startDate)

            Date endDate = Date.parse(datePattern, "2018-07-18")
            log.warn("--end date:" + endDate)
            List<String> routelist = [ 'AMD:IAD','AMD:MCO','ATL:COK','ATL:MAA','BLR:ATL','BLR:LAX','BNA:DEL','BOM:ATL','BOM:BOM','BOM:BOS','BOM:EWR','BOM:IAH','BOM:SEA','DEL:ATL','DEL:EWR','DEL:LAX','DEL:ORD','DEN:DEL','DFW:COK','DFW:DFW','EWR:AMD','EWR:JFK','HYD:ATL','HYD:AUS','HYD:EWR','HYD:LAX','HYD:PHL','HYD:SFO','IAD:BOM','IAD:CCU','IAD:COK','IAD:DEL','IAD:MAA','IAH:DEL','JFK:CCU','JFK:VGA','LAX:BLR','LAX:MAA','LKO:JFK','MAA:ATL','MAA:ORD','MIA:BOM','MSY:HYD','ORD:BLR','ORD:ORD','PHL:DEL','PHL:MAA','PHX:HYD','RDU:BLR','RDU:BOM','RDU:MAA','SAN:BOM','SEA:SEA','SFO:AMD','STL:HYD','AMD:BOS','AUS:HYD','BOS:BLR','CCU:JFK','DEL:JFK','DFW:BOM','EWR:BLR','EWR:HYD','HYD:DFW','HYD:IAD','HYD:JFK','HYD:ORD','HYD:SFO','IAD:BLR','IAD:HYD','IAH:DEL','IAH:HYD','JFK:BLR','JFK:HYD','LAX:BLR','LAX:LAX','LAX:LAX','MAA:JFK','MAA:SFO','ORD:ORD','PHX:DEL','PHX:MAA','SEA:BLR','SFO:BLR','SFO:COK','SFO:VTZ','ATL:ATL','ATL:BOM','BOM:DFW','BOM:IAD','BOM:LAX','BOS:HYD','DFW:DEL','HYD:DFW','HYD:HYD','IAH:BOM','JFK:AMD','ORD:COK','ORD:HYD','PHX:HYD','SEA:HYD','ATL:BLR','BOM:ORD','DEL:LAX','DFW:HYD','DFW:MAA','EWR:DEL','EWR:MAA','HYD:IAD','IAD:MAA','JFK:MAA','LAX:CCU','LAX:HYD','ORD:DEL','SEA:DEL','SFO:HYD','BOS:BOM','BOS:DEL','DFW:DEL','EWR:EWR','HYD:IAH','HYD:JFK','JFK:JFK','JFK:TRV','LAX:DEL','ORD:CCU','SFO:SFO','BOM:JFK','BOS:MAA','LAX:MAA','ORD:AMD','ORD:BOM','ORD:MAA','SFO:CCU','EWR:HYD','IAD:AMD','JFK:HYD','SFO:DEL','BOM:BOS','BOM:SFO','IAD:HYD','JFK:COK','ORD:MAA','ATL:HYD','DEL:SFO','IAD:BOM','ORD:BLR','ATL:DEL','LAX:BOM','ORD:DEL','JFK:DEL','EWR:AMD','IAD:DEL','SFO:HYD','JFK:AMD','SFO:MAA','JFK:MAA','JFK:BOM','ORD:HYD','SFO:BOM','EWR:BOM','SFO:BLR','LAX:DEL','JFK:DEL','SFO:DEL']
            bufWriter.writeLine("-------------------------------")
            routelist.each {
                String origin = it.split(":")[0]
                String destination = it.split(":")[1]
                Integer count = airSearchRequestAnalyticRepository.findAnalyticBetweenDates(startDate, endDate, origin, destination)
                log.warn(' origin:' + origin + '-' + destination + ' = '+ count)
                bufWriter.writeLine(""+origin + '-' + destination + ' : ' + count)
            }
            bufWriter.close()
            writer.close()
        }catch (Exception e){
            log.warn("-----exception"+e)
        }

    }

    @Test
    void getSearches() {
        OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream("countryCode.csv"), "UTF-8")
        BufferedWriter bufWriter = new BufferedWriter(writer)


        Date startDate = Date.parse(datePattern, "2018-06-18")
        log.warn("--start date:" + startDate)

        Date endDate = Date.parse(datePattern, "2018-07-18")
        log.warn("--end date:" + endDate)
        List<String[]> result = airSearchRequestAnalyticRepository.findAnalyticInDates(startDate, endDate) as List<String[]>
        result.each {
         bufWriter.writeLine(it.toString())
        }
        bufWriter.close()
        writer.close()
    }

    @Test
    void getCountByReqDate(){
        Date requestDate = Date.parse(datePattern, "2018-07-28")
        log.warn('************** requestDate: count'+airSearchRequestAnalyticRepository.findAirSearchRequestAnalyticByRequestDate(requestDate).size())
    }

}
