# mmda-data-sniffer
[![Build Status](https://travis-ci.org/esgeronimo/mmda-data-sniffer.svg?branch=master)](https://travis-ci.org/esgeronimo/mmda-data-sniffer)

Just some application that gets data from MMDA Interaksyon occasionally and stores information in a MongoDB database.

## Document Structure
### Traffic Report
Information regarding traffic congestion per specific location
#### Line
```
{
     id: String, //required
     name: String, //required
     trafficPoints: [TrafficPoint] //min 1
}
```
#### TrafficPoint
```
{
     id: String, //required
     timestamp: Long, //required
     lineId: String, //required
     lineName: String, //required
     name: String, //required
     route: [Route], //min 1
     advisories: [Advisory]
}
```
#### Route
```
{
     name: String, //required
     congestionLevel: Integer //required
}
```
#### Advisory
```
{
     lineId: String, //required
     trafficPointId: String, //required
     message: String, //required
}
```

Sample document stored in database:
```
{
    "_id" : ObjectId("592067d076b23f0ca890b0be"),
    "_class" : "com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.TrafficReport",
    "timestamp" : NumberLong(1495295951644),
    "lines" : [ 
        {
            "_id" : "1",
            "name" : "EDSA",
            "trafficPoints" : [ 
                {
                    "_id" : "1",
                    "lineId" : "1",
                    "lineName" : "EDSA",
                    "name" : "Balintawak",
                    "routes" : [ 
                        {
                            "name" : "North Bound",
                            "timestamp" : NumberLong(20170521000706),
                            "congestionLevel" : 2
                        }, 
                        {
                            "name" : "South Bound",
                            "timestamp" : NumberLong(20170521000706),
                            "congestionLevel" : 1
                        }
                    ],
                    "advisories" : [
                         {
                              "lineId" : "1",
                              "trafficPoint" : "1",
                              "message" : "MMDA ALERT: Ongoing DPWH Road Re-blocking at EDSA Quezon Ave. SB as of 6:21 AM. 1 lane occupied. Expect heavy traffic in the area."
                         }
                    ]
                } 
            ]
        },
        ...
    ]
}
```
