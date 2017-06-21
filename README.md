# mmda-data-sniffer
[![Build Status](https://travis-ci.org/esgeronimo/mmda-data-sniffer.svg?branch=master)](https://travis-ci.org/esgeronimo/mmda-data-sniffer)

Captures information from the [MMDA Interaksyon Traffic Monitoring System](http://mmdatraffic.interaksyon.com/system-view.php) through the following URLs:
* http://mmdatraffic.interaksyon.com/data.traffic.status.php?_=TIMESTAMP
* http://mmdatraffic.interaksyon.com/data.traffic.advisories.php?_=TIMESTAMP

What this application does with the information is:
* Transform information retrieved into a more "readable" structure
* Advisories are merged with the traffic status information based on their corresponding "traffic points"
* Save information in a MongoDB database for future use

Sample document structure:
```
{
  "_id": "9adae047-05b1-43bc-9e4b-97dd93d8fa69",
  "_class": "com.eugenegeronimo.mmda.mmdadatasniffer.core.trafficreport.TrafficReport",
  "timestamp": 1498014029550,
  "lines": [
    {
      "lineId": "1",
      "name": "EDSA",
      "trafficPoints": [
        {
          "trafficPointId": "30",
          "lineId": "1",
          "lineName": "EDSA",
          "name": "Magallanes",
          "routes": [
            {
              "name": "North Bound",
              "timestamp": 20170621110840,
              "congestionLevel": 4
            },
            {
              "name": "South Bound",
              "timestamp": 20170621110840,
              "congestionLevel": 1
            }
          ],
          "advisories": [
            {
              "lineId": "1",
              "trafficPointId": "30",
              "message": "ADVISORY: DPWH Expansion Joint Rehabilitation at EDSA Magallanes F/O  SB. as of 11:58 PM. 1 lane occupied."
            },
            {
              "lineId": "1",
              "trafficPointId": "30",
              "message": "ADVISORY: Ongoing Skyway Stage 3 works along Osmena Highway and Quirino Avenue."
            }
          ]
        },
        ...
      ]
    },
    ...
  ]
}
```
