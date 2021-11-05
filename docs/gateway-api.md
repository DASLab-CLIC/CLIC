<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [任务提交接口](#%E4%BB%BB%E5%8A%A1%E6%8F%90%E4%BA%A4%E6%8E%A5%E5%8F%A3)
  - [简要描述](#%E7%AE%80%E8%A6%81%E6%8F%8F%E8%BF%B0)
  - [请求URL示例](#%E8%AF%B7%E6%B1%82url%E7%A4%BA%E4%BE%8B)
  - [请求方式](#%E8%AF%B7%E6%B1%82%E6%96%B9%E5%BC%8F)
  - [参数](#%E5%8F%82%E6%95%B0)
  - [请求体示例](#%E8%AF%B7%E6%B1%82%E4%BD%93%E7%A4%BA%E4%BE%8B)
  - [返回示例](#%E8%BF%94%E5%9B%9E%E7%A4%BA%E4%BE%8B)
- [查看结果接口](#%E6%9F%A5%E7%9C%8B%E7%BB%93%E6%9E%9C%E6%8E%A5%E5%8F%A3)
  - [简要描述](#%E7%AE%80%E8%A6%81%E6%8F%8F%E8%BF%B0-1)
  - [请求URL](#%E8%AF%B7%E6%B1%82url)
  - [请求方式](#%E8%AF%B7%E6%B1%82%E6%96%B9%E5%BC%8F-1)
  - [参数](#%E5%8F%82%E6%95%B0-1)
  - [返回示例](#%E8%BF%94%E5%9B%9E%E7%A4%BA%E4%BE%8B-1)
- [查看任务状态接口](#%E6%9F%A5%E7%9C%8B%E4%BB%BB%E5%8A%A1%E7%8A%B6%E6%80%81%E6%8E%A5%E5%8F%A3)
  - [简要描述](#%E7%AE%80%E8%A6%81%E6%8F%8F%E8%BF%B0-2)
  - [请求URL](#%E8%AF%B7%E6%B1%82url-1)
  - [请求方式](#%E8%AF%B7%E6%B1%82%E6%96%B9%E5%BC%8F-2)
  - [参数](#%E5%8F%82%E6%95%B0-2)
  - [返回示例](#%E8%BF%94%E5%9B%9E%E7%A4%BA%E4%BE%8B-2)
- [修改算子信息接口](#%E4%BF%AE%E6%94%B9%E7%AE%97%E5%AD%90%E4%BF%A1%E6%81%AF%E6%8E%A5%E5%8F%A3)
  - [简要描述](#%E7%AE%80%E8%A6%81%E6%8F%8F%E8%BF%B0-3)
  - [请求URL示例](#%E8%AF%B7%E6%B1%82url%E7%A4%BA%E4%BE%8B-1)
  - [请求方式](#%E8%AF%B7%E6%B1%82%E6%96%B9%E5%BC%8F-3)
  - [参数](#%E5%8F%82%E6%95%B0-3)
  - [请求体示例](#%E8%AF%B7%E6%B1%82%E4%BD%93%E7%A4%BA%E4%BE%8B-1)
  - [返回示例](#%E8%BF%94%E5%9B%9E%E7%A4%BA%E4%BE%8B-3)
- [修改平台元信息](#%E4%BF%AE%E6%94%B9%E5%B9%B3%E5%8F%B0%E5%85%83%E4%BF%A1%E6%81%AF)
  - [简要描述](#%E7%AE%80%E8%A6%81%E6%8F%8F%E8%BF%B0-4)
  - [请求URL](#%E8%AF%B7%E6%B1%82url-2)
  - [请求方式](#%E8%AF%B7%E6%B1%82%E6%96%B9%E5%BC%8F-4)
  - [参数](#%E5%8F%82%E6%95%B0-4)
  - [请求体示例](#%E8%AF%B7%E6%B1%82%E4%BD%93%E7%A4%BA%E4%BE%8B-2)
  - [返回示例](#%E8%BF%94%E5%9B%9E%E7%A4%BA%E4%BE%8B-4)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->


# 任务提交接口

## 简要描述

- 任务提交接口

## 请求URL示例
- ` http://127.0.0.1:8080/job/submit?jobName=simple `

## 请求方式
- POST

## 参数
|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|jobName |是  |string |任务名   |

## 请求体示例

```
{
  "planParams": [
    {
      "name": "dev-imagePolicy",
      "value": "Always"
    }
  ],
  "operators": [
    {
      "Id": 1,
      "Platform": "pytorch",
      "Name": "SourceOperator",
      "Params": [
        {"name": "udfPath", "value": "/data/user/sentiment/TestUdf.py"},
        {"name": "inputPath", "value": "/data/user/sentiment/amazon_reviews/test.ft.csv"},
        {"name": "type", "value": "udf"}
      ],
      "inputKeys": [],
      "outputKeys": ["result"]
    },
    {
      "Id": 2,
      "Platform": "pytorch",
      "Name": "TokenizedOperator",
      "Params": [],
      "inputKeys":[
        {"name": "data", "from": 1, "key": "result"}
      ],
      "outputKeys": ["result"]
    },
    {
      "Id": 3,
      "Platform": "pytorch",
      "Name": "GetVocabOperator",
      "Params": [
        {"name": "min_freq", "value": "5"}
      ],
      "inputKeys": [
        {"name": "data", "from": 2, "key": "result"}
      ],
      "outputKeys": ["result"]
    },
    {
      "Id": 4,
      "Platform": "pytorch",
      "Name": "PreprocessImdbOperator",
      "Params": [
        {"name": "max_l", "value": "500"}
      ],
      "inputKeys": [
        {"name": "data", "from": 1, "key": "result"},
        {"name": "vocab", "from": 3, "key": "result"},
        {"name": "tokenized_data", "from": 2, "key": "result"}
      ],
      "outputKeys": ["result"]
    },
    {
      "Id": 5,
      "Platform": "pytorch",
      "Name": "DataLoadOperator",
      "Params": [
        {"name": "batch_size", "value": "64"},
        {"name": "shuffle", "value": "True"}
      ],
      "inputKeys": [
        {"name": "data", "from": 4, "key": "result"}
      ],
      "outputKeys": ["result"]
    },
    {
      "Id": 10,
      "Platform": "spark",
      "Name": "SourceOperator",
      "Params": [
        {"name": "inputPath", "value": "/data/user/spark_w2v/ptb.train.txt"},
        {"name": "separator", "value": ","}
      ],
      "inputKeys": [],
      "outputKeys": ["result"]
    },
    {
      "Id": 6,
      "Platform": "spark",
      "Name": "W2VOperator",
      "Params": [
        {"name": "fit", "value": "true"},
        {"name": "vectorSize", "value": "100"}
      ],
      "inputKeys": [
        {"name": "data", "from": 10, "key": "result"}
      ],
      "outputKeys": ["result"]
    },
    {
      "Id": 7,
      "Platform": "pytorch",
      "Name": "GetWordDictOperator",
      "Params": [],
      "inputKeys": [
        {"name": "data", "from": 6, "key": "result"}
      ],
      "outputKeys": ["result"]
    },
    {
      "Id": 8,
      "Platform": "pytorch",
      "Name": "NetProcessOperator",
      "Params": [
        {"name": "udfPath", "value": "/data/user/sentiment/TestUdf.py"}
      ],
      "inputKeys": [
        {"name": "vocab", "from": 3, "key": "result"},
        {"name": "w2v_dict", "from": 7, "key": "result"}
      ],
      "outputKeys": ["result"]
    },
    {
      "Id": 9,
      "Platform": "pytorch",
      "Name": "TrainOperator",
      "Params": [
        {"name": "udfPath", "value": "/data/user/sentiment/TestUdf.py"},
        {"name": "num_epochs", "value": "3"},
        {"name": "tol_threshold", "value": "1e-6"}
      ],
      "inputKeys": [
        {"name": "net", "from": 8, "key": "result"},
        {"name": "data", "from": 5, "key": "result"}
      ],
      "outputKeys": ["result"]
    }
  ]
}
```

## 返回示例

``` 
{
    "msg": "success",
    "code": 0,
    "data": null
}
```


# 查看结果接口

## 简要描述

- 查看各Stage结果, 返回的是结果在后端的路径

## 请求URL
- ` http://127.0.0.1:8080/job/getresult?jobName=simple `
  
## 请求方式
- GET 

## 参数

| 参数名  | 必选 | 类型   | 说明   |
| :------ | :--- | :----- | ------ |
| jobName | 是   | string | 任务名 |

## 返回示例 

``` 
{
    "msg": "success",
    "code": 0,
    "data": {
        "1941095166": {},
        "33186741": {
            "45327070": "/Users/edward/Code/Lab/data/4d465a62-64a2-4e49-98f9-b7f495d3fc8b"
        }
    }
}
```


# 查看任务状态接口

## 简要描述

- 查看任务状态

## 请求URL
- ` http://127.0.0.1:8080/job/check?jobName=simple `
  
## 请求方式
- GET 

## 参数

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|jobName |是  |string |任务名   |


## 返回示例 

``` 
{
    "msg": "success",
    "code": 0,
    "data": {
        "jobName": "simple",
        "subplans": {
            "1941095166": {
                "stageId": 1941095166,
                "planInfo": {
                    "nodes": {
                        "1": {
                            "nodeId": 1,
                            "operatorInfo": {
                                "name": "SourceOperator",
                                "possiblePlatforms": [],
                                "operatorStructure": null,
                                "operatorType": null,
                                "computeComplex": null,
                                "inputKeys": [],
                                "outputKeys": [
                                    "result"
                                ],
                                "params": {
                                    "inputPath": "/data/user/sentiment/amazon_reviews/test.ft.csv",
                                    "udfPath": "/data/user/sentiment/TestUdf.py",
                                    "type": "udf"
                                },
                                "setPossiblePlatforms": true,
                                "possiblePlatformsSize": 0,
                                "possiblePlatformsIterator": [],
                                "inputKeysSize": 0,
                                "paramsSize": 3,
                                "setInputKeys": true,
                                "setName": true,
                                "setOutputKeys": true,
                                "setParams": true,
                                "outputKeysSize": 1,
                                "setOperatorType": false,
                                "inputKeysIterator": [],
                                "setOperatorStructure": false,
                                "outputKeysIterator": [
                                    "result"
                                ],
                                "setComputeComplex": false
                            },
                            "inputNodeId": [],
                            "outputNodeId": [
                                2,
                                4
                            ],
                            "platformName": "pytorch",
                            "setOperatorInfo": true,
                            "inputNodeIdSize": 0,
                            "inputNodeIdIterator": [],
                            "setPlatformName": true,
                            "setOutputNodeId": true,
                            "outputNodeIdSize": 2,
                            "outputNodeIdIterator": [
                                2,
                                4
                            ],
                            "setInputNodeId": true,
                            "setNodeId": true
                        },
                        "2": {
                            "nodeId": 2,
                            "operatorInfo": {
                                "name": "TokenizedOperator",
                                "possiblePlatforms": [],
                                "operatorStructure": null,
                                "operatorType": null,
                                "computeComplex": null,
                                "inputKeys": [
                                    "data"
                                ],
                                "outputKeys": [
                                    "result"
                                ],
                                "params": {},
                                "setPossiblePlatforms": true,
                                "possiblePlatformsSize": 0,
                                "possiblePlatformsIterator": [],
                                "inputKeysSize": 1,
                                "paramsSize": 0,
                                "setInputKeys": true,
                                "setName": true,
                                "setOutputKeys": true,
                                "setParams": true,
                                "outputKeysSize": 1,
                                "setOperatorType": false,
                                "inputKeysIterator": [
                                    "data"
                                ],
                                "setOperatorStructure": false,
                                "outputKeysIterator": [
                                    "result"
                                ],
                                "setComputeComplex": false
                            },
                            "inputNodeId": [
                                1
                            ],
                            "outputNodeId": [
                                3,
                                4
                            ],
                            "platformName": "pytorch",
                            "setOperatorInfo": true,
                            "inputNodeIdSize": 1,
                            "inputNodeIdIterator": [
                                1
                            ],
                            "setPlatformName": true,
                            "setOutputNodeId": true,
                            "outputNodeIdSize": 2,
                            "outputNodeIdIterator": [
                                3,
                                4
                            ],
                            "setInputNodeId": true,
                            "setNodeId": true
                        },
                        "3": {
                            "nodeId": 3,
                            "operatorInfo": {
                                "name": "GetVocabOperator",
                                "possiblePlatforms": [],
                                "operatorStructure": null,
                                "operatorType": null,
                                "computeComplex": null,
                                "inputKeys": [
                                    "data"
                                ],
                                "outputKeys": [
                                    "result"
                                ],
                                "params": {
                                    "min_freq": "5"
                                },
                                "setPossiblePlatforms": true,
                                "possiblePlatformsSize": 0,
                                "possiblePlatformsIterator": [],
                                "inputKeysSize": 1,
                                "paramsSize": 1,
                                "setInputKeys": true,
                                "setName": true,
                                "setOutputKeys": true,
                                "setParams": true,
                                "outputKeysSize": 1,
                                "setOperatorType": false,
                                "inputKeysIterator": [
                                    "data"
                                ],
                                "setOperatorStructure": false,
                                "outputKeysIterator": [
                                    "result"
                                ],
                                "setComputeComplex": false
                            },
                            "inputNodeId": [
                                2
                            ],
                            "outputNodeId": [
                                4,
                                8
                            ],
                            "platformName": "pytorch",
                            "setOperatorInfo": true,
                            "inputNodeIdSize": 1,
                            "inputNodeIdIterator": [
                                2
                            ],
                            "setPlatformName": true,
                            "setOutputNodeId": true,
                            "outputNodeIdSize": 2,
                            "outputNodeIdIterator": [
                                4,
                                8
                            ],
                            "setInputNodeId": true,
                            "setNodeId": true
                        },
                        "4": {
                            "nodeId": 4,
                            "operatorInfo": {
                                "name": "PreprocessImdbOperator",
                                "possiblePlatforms": [],
                                "operatorStructure": null,
                                "operatorType": null,
                                "computeComplex": null,
                                "inputKeys": [
                                    "data",
                                    "vocab",
                                    "tokenized_data"
                                ],
                                "outputKeys": [
                                    "result"
                                ],
                                "params": {
                                    "max_l": "500"
                                },
                                "setPossiblePlatforms": true,
                                "possiblePlatformsSize": 0,
                                "possiblePlatformsIterator": [],
                                "inputKeysSize": 3,
                                "paramsSize": 1,
                                "setInputKeys": true,
                                "setName": true,
                                "setOutputKeys": true,
                                "setParams": true,
                                "outputKeysSize": 1,
                                "setOperatorType": false,
                                "inputKeysIterator": [
                                    "data",
                                    "vocab",
                                    "tokenized_data"
                                ],
                                "setOperatorStructure": false,
                                "outputKeysIterator": [
                                    "result"
                                ],
                                "setComputeComplex": false
                            },
                            "inputNodeId": [
                                1,
                                3,
                                2
                            ],
                            "outputNodeId": [
                                5
                            ],
                            "platformName": "pytorch",
                            "setOperatorInfo": true,
                            "inputNodeIdSize": 3,
                            "inputNodeIdIterator": [
                                1,
                                3,
                                2
                            ],
                            "setPlatformName": true,
                            "setOutputNodeId": true,
                            "outputNodeIdSize": 1,
                            "outputNodeIdIterator": [
                                5
                            ],
                            "setInputNodeId": true,
                            "setNodeId": true
                        },
                        "5": {
                            "nodeId": 5,
                            "operatorInfo": {
                                "name": "DataLoadOperator",
                                "possiblePlatforms": [],
                                "operatorStructure": null,
                                "operatorType": null,
                                "computeComplex": null,
                                "inputKeys": [
                                    "data"
                                ],
                                "outputKeys": [
                                    "result"
                                ],
                                "params": {
                                    "shuffle": "True",
                                    "batch_size": "64"
                                },
                                "setPossiblePlatforms": true,
                                "possiblePlatformsSize": 0,
                                "possiblePlatformsIterator": [],
                                "inputKeysSize": 1,
                                "paramsSize": 2,
                                "setInputKeys": true,
                                "setName": true,
                                "setOutputKeys": true,
                                "setParams": true,
                                "outputKeysSize": 1,
                                "setOperatorType": false,
                                "inputKeysIterator": [
                                    "data"
                                ],
                                "setOperatorStructure": false,
                                "outputKeysIterator": [
                                    "result"
                                ],
                                "setComputeComplex": false
                            },
                            "inputNodeId": [
                                4
                            ],
                            "outputNodeId": [
                                9
                            ],
                            "platformName": "pytorch",
                            "setOperatorInfo": true,
                            "inputNodeIdSize": 1,
                            "inputNodeIdIterator": [
                                4
                            ],
                            "setPlatformName": true,
                            "setOutputNodeId": true,
                            "outputNodeIdSize": 1,
                            "outputNodeIdIterator": [
                                9
                            ],
                            "setInputNodeId": true,
                            "setNodeId": true
                        },
                        "7": {
                            "nodeId": 7,
                            "operatorInfo": {
                                "name": "GetWordDictOperator",
                                "possiblePlatforms": [],
                                "operatorStructure": null,
                                "operatorType": null,
                                "computeComplex": null,
                                "inputKeys": [
                                    "data"
                                ],
                                "outputKeys": [
                                    "result"
                                ],
                                "params": {},
                                "setPossiblePlatforms": true,
                                "possiblePlatformsSize": 0,
                                "possiblePlatformsIterator": [],
                                "inputKeysSize": 1,
                                "paramsSize": 0,
                                "setInputKeys": true,
                                "setName": true,
                                "setOutputKeys": true,
                                "setParams": true,
                                "outputKeysSize": 1,
                                "setOperatorType": false,
                                "inputKeysIterator": [
                                    "data"
                                ],
                                "setOperatorStructure": false,
                                "outputKeysIterator": [
                                    "result"
                                ],
                                "setComputeComplex": false
                            },
                            "inputNodeId": [
                                -1014869814
                            ],
                            "outputNodeId": [
                                8
                            ],
                            "platformName": "pytorch",
                            "setOperatorInfo": true,
                            "inputNodeIdSize": 1,
                            "inputNodeIdIterator": [
                                -1014869814
                            ],
                            "setPlatformName": true,
                            "setOutputNodeId": true,
                            "outputNodeIdSize": 1,
                            "outputNodeIdIterator": [
                                8
                            ],
                            "setInputNodeId": true,
                            "setNodeId": true
                        },
                        "8": {
                            "nodeId": 8,
                            "operatorInfo": {
                                "name": "NetProcessOperator",
                                "possiblePlatforms": [],
                                "operatorStructure": null,
                                "operatorType": null,
                                "computeComplex": null,
                                "inputKeys": [
                                    "vocab",
                                    "w2v_dict"
                                ],
                                "outputKeys": [
                                    "result"
                                ],
                                "params": {
                                    "udfPath": "/data/user/sentiment/TestUdf.py"
                                },
                                "setPossiblePlatforms": true,
                                "possiblePlatformsSize": 0,
                                "possiblePlatformsIterator": [],
                                "inputKeysSize": 2,
                                "paramsSize": 1,
                                "setInputKeys": true,
                                "setName": true,
                                "setOutputKeys": true,
                                "setParams": true,
                                "outputKeysSize": 1,
                                "setOperatorType": false,
                                "inputKeysIterator": [
                                    "vocab",
                                    "w2v_dict"
                                ],
                                "setOperatorStructure": false,
                                "outputKeysIterator": [
                                    "result"
                                ],
                                "setComputeComplex": false
                            },
                            "inputNodeId": [
                                3,
                                7
                            ],
                            "outputNodeId": [
                                9
                            ],
                            "platformName": "pytorch",
                            "setOperatorInfo": true,
                            "inputNodeIdSize": 2,
                            "inputNodeIdIterator": [
                                3,
                                7
                            ],
                            "setPlatformName": true,
                            "setOutputNodeId": true,
                            "outputNodeIdSize": 1,
                            "outputNodeIdIterator": [
                                9
                            ],
                            "setInputNodeId": true,
                            "setNodeId": true
                        },
                        "-1014869814": {
                            "nodeId": -1014869814,
                            "operatorInfo": {
                                "name": "SourceOperator",
                                "possiblePlatforms": [],
                                "operatorStructure": "SOURCE",
                                "operatorType": null,
                                "computeComplex": null,
                                "inputKeys": [
                                    "data"
                                ],
                                "outputKeys": [
                                    "result"
                                ],
                                "params": {
                                    "separator": ",",
                                    "inputPath": "/Users/edward/Code/Lab/data/4d465a62-64a2-4e49-98f9-b7f495d3fc8b"
                                },
                                "setPossiblePlatforms": true,
                                "possiblePlatformsSize": 0,
                                "possiblePlatformsIterator": [],
                                "inputKeysSize": 1,
                                "paramsSize": 2,
                                "setInputKeys": true,
                                "setName": true,
                                "setOutputKeys": true,
                                "setParams": true,
                                "outputKeysSize": 1,
                                "setOperatorType": false,
                                "inputKeysIterator": [
                                    "data"
                                ],
                                "setOperatorStructure": true,
                                "outputKeysIterator": [
                                    "result"
                                ],
                                "setComputeComplex": false
                            },
                            "inputNodeId": [],
                            "outputNodeId": [
                                7
                            ],
                            "platformName": "pytorch",
                            "setOperatorInfo": true,
                            "inputNodeIdSize": 0,
                            "inputNodeIdIterator": [],
                            "setPlatformName": true,
                            "setOutputNodeId": true,
                            "outputNodeIdSize": 1,
                            "outputNodeIdIterator": [
                                7
                            ],
                            "setInputNodeId": true,
                            "setNodeId": true
                        },
                        "9": {
                            "nodeId": 9,
                            "operatorInfo": {
                                "name": "TrainOperator",
                                "possiblePlatforms": [],
                                "operatorStructure": null,
                                "operatorType": null,
                                "computeComplex": null,
                                "inputKeys": [
                                    "net",
                                    "data"
                                ],
                                "outputKeys": [
                                    "result"
                                ],
                                "params": {
                                    "udfPath": "/data/user/sentiment/TestUdf.py",
                                    "num_epochs": "3",
                                    "tol_threshold": "1e-6"
                                },
                                "setPossiblePlatforms": true,
                                "possiblePlatformsSize": 0,
                                "possiblePlatformsIterator": [],
                                "inputKeysSize": 2,
                                "paramsSize": 3,
                                "setInputKeys": true,
                                "setName": true,
                                "setOutputKeys": true,
                                "setParams": true,
                                "outputKeysSize": 1,
                                "setOperatorType": false,
                                "inputKeysIterator": [
                                    "net",
                                    "data"
                                ],
                                "setOperatorStructure": false,
                                "outputKeysIterator": [
                                    "result"
                                ],
                                "setComputeComplex": false
                            },
                            "inputNodeId": [
                                8,
                                5
                            ],
                            "outputNodeId": [],
                            "platformName": "pytorch",
                            "setOperatorInfo": true,
                            "inputNodeIdSize": 2,
                            "inputNodeIdIterator": [
                                8,
                                5
                            ],
                            "setPlatformName": true,
                            "setOutputNodeId": true,
                            "outputNodeIdSize": 0,
                            "outputNodeIdIterator": [],
                            "setInputNodeId": true,
                            "setNodeId": true
                        }
                    },
                    "sourceNodes": [
                        -1014869814,
                        -1014869814
                    ],
                    "sinkNodes": [],
                    "others": {},
                    "sourceNodesSize": 2,
                    "sinkNodesIterator": [],
                    "sourceNodesIterator": [
                        -1014869814,
                        -1014869814
                    ],
                    "othersSize": 0,
                    "setOthers": true,
                    "nodesSize": 9,
                    "setSourceNodes": true,
                    "sinkNodesSize": 0,
                    "setSinkNodes": true,
                    "setNodes": true
                },
                "platformName": "pytorch",
                "inputStageId": [
                    33186741
                ],
                "outputStageId": [],
                "stageStatus": null,
                "startTime": null,
                "endTime": null,
                "jobName": "simple",
                "others": {
                    "dev-imagePolicy": "Always"
                },
                "setOutputStageId": true,
                "inputStageIdIterator": [
                    33186741
                ],
                "inputStageIdSize": 1,
                "setInputStageId": true,
                "outputStageIdSize": 0,
                "outputStageIdIterator": [],
                "setPlanInfo": true,
                "setStageId": true,
                "setStageStatus": false,
                "setPlatformName": true,
                "setStartTime": false,
                "setEndTime": false,
                "othersSize": 1,
                "setJobName": true,
                "setOthers": true
            },
            "33186741": {
                "stageId": 33186741,
                "planInfo": {
                    "nodes": {
                        "10": {
                            "nodeId": 10,
                            "operatorInfo": {
                                "name": "SourceOperator",
                                "possiblePlatforms": [],
                                "operatorStructure": null,
                                "operatorType": null,
                                "computeComplex": null,
                                "inputKeys": [],
                                "outputKeys": [
                                    "result"
                                ],
                                "params": {
                                    "separator": ",",
                                    "inputPath": "/data/user/spark_w2v/ptb.train.txt"
                                },
                                "setPossiblePlatforms": true,
                                "possiblePlatformsSize": 0,
                                "possiblePlatformsIterator": [],
                                "inputKeysSize": 0,
                                "paramsSize": 2,
                                "setInputKeys": true,
                                "setName": true,
                                "setOutputKeys": true,
                                "setParams": true,
                                "outputKeysSize": 1,
                                "setOperatorType": false,
                                "inputKeysIterator": [],
                                "setOperatorStructure": false,
                                "outputKeysIterator": [
                                    "result"
                                ],
                                "setComputeComplex": false
                            },
                            "inputNodeId": [],
                            "outputNodeId": [
                                6
                            ],
                            "platformName": "spark",
                            "setOperatorInfo": true,
                            "inputNodeIdSize": 0,
                            "inputNodeIdIterator": [],
                            "setPlatformName": true,
                            "setOutputNodeId": true,
                            "outputNodeIdSize": 1,
                            "outputNodeIdIterator": [
                                6
                            ],
                            "setInputNodeId": true,
                            "setNodeId": true
                        },
                        "45327070": {
                            "nodeId": 45327070,
                            "operatorInfo": {
                                "name": "SinkOperator",
                                "possiblePlatforms": [],
                                "operatorStructure": "SINK",
                                "operatorType": null,
                                "computeComplex": null,
                                "inputKeys": [
                                    "data"
                                ],
                                "outputKeys": [
                                    "result"
                                ],
                                "params": {
                                    "separator": ",",
                                    "outputPath": "/Users/edward/Code/Lab/data/4d465a62-64a2-4e49-98f9-b7f495d3fc8b"
                                },
                                "setPossiblePlatforms": true,
                                "possiblePlatformsSize": 0,
                                "possiblePlatformsIterator": [],
                                "inputKeysSize": 1,
                                "paramsSize": 2,
                                "setInputKeys": true,
                                "setName": true,
                                "setOutputKeys": true,
                                "setParams": true,
                                "outputKeysSize": 1,
                                "setOperatorType": false,
                                "inputKeysIterator": [
                                    "data"
                                ],
                                "setOperatorStructure": true,
                                "outputKeysIterator": [
                                    "result"
                                ],
                                "setComputeComplex": false
                            },
                            "inputNodeId": [
                                6
                            ],
                            "outputNodeId": [],
                            "platformName": "spark",
                            "setOperatorInfo": true,
                            "inputNodeIdSize": 1,
                            "inputNodeIdIterator": [
                                6
                            ],
                            "setPlatformName": true,
                            "setOutputNodeId": true,
                            "outputNodeIdSize": 0,
                            "outputNodeIdIterator": [],
                            "setInputNodeId": true,
                            "setNodeId": true
                        },
                        "6": {
                            "nodeId": 6,
                            "operatorInfo": {
                                "name": "W2VOperator",
                                "possiblePlatforms": [],
                                "operatorStructure": null,
                                "operatorType": null,
                                "computeComplex": null,
                                "inputKeys": [
                                    "data"
                                ],
                                "outputKeys": [
                                    "result"
                                ],
                                "params": {
                                    "fit": "true",
                                    "vectorSize": "100"
                                },
                                "setPossiblePlatforms": true,
                                "possiblePlatformsSize": 0,
                                "possiblePlatformsIterator": [],
                                "inputKeysSize": 1,
                                "paramsSize": 2,
                                "setInputKeys": true,
                                "setName": true,
                                "setOutputKeys": true,
                                "setParams": true,
                                "outputKeysSize": 1,
                                "setOperatorType": false,
                                "inputKeysIterator": [
                                    "data"
                                ],
                                "setOperatorStructure": false,
                                "outputKeysIterator": [
                                    "result"
                                ],
                                "setComputeComplex": false
                            },
                            "inputNodeId": [
                                10
                            ],
                            "outputNodeId": [
                                45327070
                            ],
                            "platformName": "spark",
                            "setOperatorInfo": true,
                            "inputNodeIdSize": 1,
                            "inputNodeIdIterator": [
                                10
                            ],
                            "setPlatformName": true,
                            "setOutputNodeId": true,
                            "outputNodeIdSize": 1,
                            "outputNodeIdIterator": [
                                45327070
                            ],
                            "setInputNodeId": true,
                            "setNodeId": true
                        }
                    },
                    "sourceNodes": [],
                    "sinkNodes": [
                        45327070
                    ],
                    "others": {},
                    "sourceNodesSize": 0,
                    "sinkNodesIterator": [
                        45327070
                    ],
                    "sourceNodesIterator": [],
                    "othersSize": 0,
                    "setOthers": true,
                    "nodesSize": 3,
                    "setSourceNodes": true,
                    "sinkNodesSize": 1,
                    "setSinkNodes": true,
                    "setNodes": true
                },
                "platformName": "spark",
                "inputStageId": [],
                "outputStageId": [
                    1941095166
                ],
                "stageStatus": "PENDING",
                "startTime": null,
                "endTime": null,
                "jobName": "simple",
                "others": {
                    "dev-imagePolicy": "Always"
                },
                "setOutputStageId": true,
                "inputStageIdIterator": [],
                "inputStageIdSize": 0,
                "setInputStageId": true,
                "outputStageIdSize": 1,
                "outputStageIdIterator": [
                    1941095166
                ],
                "setPlanInfo": true,
                "setStageId": true,
                "setStageStatus": true,
                "setPlatformName": true,
                "setStartTime": false,
                "setEndTime": false,
                "othersSize": 1,
                "setJobName": true,
                "setOthers": true
            }
        },
        "sourceStages": [
            33186741
        ],
        "jobStatus": "PENDING",
        "startTime": null,
        "endTime": null,
        "others": {
            "dev-imagePolicy": "Always"
        },
        "setSourceStages": true,
        "sourceStagesSize": 1,
        "sourceStagesIterator": [
            33186741
        ],
        "setStartTime": false,
        "setEndTime": false,
        "othersSize": 1,
        "subplansSize": 2,
        "setJobName": true,
        "setSubplans": true,
        "setJobStatus": true,
        "setOthers": true
    }
}
```



# 修改算子信息接口

## 简要描述

- 修改算子元信息

## 请求URL示例
- ` http://127.0.0.1:8080/operator/updateinfo?operatorName=SinkOperator`
  
## 请求方式
- PUT

## 参数

|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|operatorName |是  |string |算子名称   |

## 请求体示例
```
{
  "possiblePlatforms": ["flink","spark"],
  "OperatorStructure": "SINK",
  "params": {"udfName": "/udf/"}
}
```
## 返回示例 

``` 
{
    "msg": "success",
    "code": 0,
    "data": null
}
```


# 修改平台元信息

## 简要描述

- 修改平台元信息

## 请求URL
- ` http://127.0.0.1:8080/platform/updateinfo?platformName=spark `
  
## 请求方式
- PUT 

## 参数
|参数名|必选|类型|说明|
|:----    |:---|:----- |-----   |
|platformName |是  |string |平台名   |

## 请求体示例

```
{
  "name": "spark",
  "defaultImage": "spark_v1",
  "useOperator": false,
  "params": {"conf": "/config.yaml"}
}
```

## 返回示例 

``` 
{
    "msg": "success",
    "code": 0,
    "data": null
}
```















