$(function () {
    echart_1();
   // echart_2();

    echart_3();
    //echart_4();



    echart_map();
  // echart_5();


    //echart_6();
    echart_7();
    echart_9();
    //echart_1湖北货物收入
    function echart_1() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('chart_1'));
        myChart.clear();
        option = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c}万元"
            },
            legend: {
                x: 'center',
                y: '20%',
                data: ['武汉', '荆门', '荆州', '十堰', '黄冈', '孝感', '襄樊', '仙桃', '天门', '咸宁', '宜昌', '鄂州', '恩施', '神农架'],
                icon: 'circle',
                textStyle: {
                    color: '#fff',
                }
            },
            calculable: true,
            series: [{
                name: '',
                type: 'pie',
                //起始角度，支持范围[0, 360]
                startAngle: 0,
                //饼图的半径，数组的第一项是内半径，第二项是外半径
                radius: [40, 140],
                //支持设置成百分比，设置成百分比时第一项是相对于容器宽度，第二项是相对于容器高度
                center: ['50%', '40%'],
                //是否展示成南丁格尔图，通过半径区分数据大小。可选择两种模式：
                // 'radius' 面积展现数据的百分比，半径展现数据的大小。
                //  'area' 所有扇区面积相同，仅通过半径展现数据大小
                roseType: 'area',
                //是否启用防止标签重叠策略，默认开启，圆环图这个例子中需要强制所有标签放在中心位置，可以将该值设为 false。
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: true,
                        formatter: '{c}万元'
                    },
                    emphasis: {
                        show: true
                    }
                },
                labelLine: {
                    normal: {
                        show: true,
                        length2: 1,
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: [{
                    value: 900.58,
                    name: '荆门',
                    itemStyle: {
                        normal: {
                            color: '#f845f1'
                        }
                    }
                },
                {
                    value: 1100.58,
                    name: '荆州',
                    itemStyle: {
                        normal: {
                            color: '#ad46f3'
                        }
                    }
                },
                {
                    value: 1200.58,
                    name: '十堰',
                    itemStyle: {
                        normal: {
                            color: '#5045f6'
                        }
                    }
                },
                {
                    value: 1300.58,
                    name: '黄冈',
                    itemStyle: {
                        normal: {
                            color: '#4777f5'
                        }
                    }
                },
                {
                    value: 1400.58,
                    name: '孝感',
                    itemStyle: {
                        normal: {
                            color: '#44aff0'
                        }
                    }
                },
                {
                    value: 1500.58,
                    name: '襄樊',
                    itemStyle: {
                        normal: {
                            color: '#45dbf7'
                        }
                    }
                },
                {
                    value: 1500.58,
                    name: '仙桃',
                    itemStyle: {
                        normal: {
                            color: '#f6d54a'
                        }
                    }
                },
                {
                    value: 1600.58,
                    name: '天门',
                    itemStyle: {
                        normal: {
                            color: '#f69846'
                        }
                    }
                },
                {
                    value: 1800,
                    name: '武汉',
                    itemStyle: {
                        normal: {
                            color: '#ff4343'
                        }
                    }
                },
                {
                    value: 0,
                    name: "",
                    itemStyle: {
                        normal: {
                            color: '#transparent'
                        }
                    },
                    label: {
                        show: false
                    },
                    labelLine: {
                        show: false
                    }
                },
                {
                    value: 0,
                    name: "",
                    itemStyle: {
                        normal: {
                            color: 'transparent'
                        }
                    },
                    label: {
                        show: false
                    },
                    labelLine: {
                        show: false
                    }
                },
                {
                    value: 0,
                    name: "",
                    itemStyle: {
                        normal: {
                            color: 'transparent'
                        }
                    },
                    label: {
                        show: false
                    },
                    labelLine: {
                        show: false
                    }
                },
                {
                    value: 0,
                    name: "",
                    itemStyle: {
                        normal: {
                            color: 'transparent'
                        }
                    },
                    label: {
                        show: false
                    },
                    labelLine: {
                        show: false
                    }
                },
                {
                    value: 0,
                    name: "",
                    itemStyle: {
                        normal: {
                            color: 'transparent'
                        }
                    },
                    label: {
                        show: false
                    },
                    labelLine: {
                        show: false
                    }
                },
                {
                    value: 0,
                    name: "",
                    itemStyle: {
                        normal: {
                            color: 'transparent'
                        }
                    },
                    label: {
                        show: false
                    },
                    labelLine: {
                        show: false
                    }
                },
                {
                    value: 0,
                    name: "",
                    itemStyle: {
                        normal: {
                            color: 'transparent'
                        }
                    },
                    label: {
                        show: false
                    },
                    labelLine: {
                        show: false
                    }
                },
                {
                    value: 0,
                    name: "",
                    itemStyle: {
                        normal: {
                            color: 'transparent'
                        }
                    },
                    label: {
                        show: false
                    },
                    labelLine: {
                        show: false
                    }
                },
                {
                    value: 0,
                    name: "",
                    itemStyle: {
                        normal: {
                            color: 'transparent'
                        }
                    },
                    label: {
                        show: false
                    },
                    labelLine: {
                        show: false
                    }
                }
                ]
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });
    }



    //echart_2湖北省地图
    function echart_2() {
           // 基于准备好的dom，初始化echarts实例
           var myChart = echarts.init(document.getElementById('chart_2'));
           function showProvince() {
                   myChart.setOption(option = {
                       // backgroundColor: '#ffffff',
                       visualMap: {
                           show: false,
                           min: 0,
                           max: 100,
                           left: 'left',
                           top: 'bottom',
                           text: ['高', '低'], // 文本，默认为数值文本
                           calculable: true,
                           inRange: {
                               color: ['yellow', 'lightskyblue', 'orangered']
                           }
                       },
                       series: [{
                           type: 'map',
                           mapType: 'hunan',
                           roam: true,
                           label: {
                               normal: {
                                   show: true
                               },
                               emphasis: {
                                   textStyle: {
                                       color: '#fff'
                                   }
                               }
                           },
                           itemStyle: {
                               normal: {
                                   borderColor: '#389BB7',
                                   areaColor: '#fff',
                               },
                               emphasis: {
                                   areaColor: '#389BB7',
                                   borderWidth: 0
                               }
                           },
                           animation: false,
                           data: [{
                        	  
                               name: '武汉',
                               value:  100
                           }, {
                               name: '荆门',
                               value: 96
                           }, {
                               name: '荆州',
                               value: 98
                           }, {
                               name: '十堰',
                               value: 80
                           }, {
                               name: '黄冈',
                               value: 88
                           }, {
                               name: '孝感',
                               value: 79
                           }, {
                               name: '襄樊',
                               value: 77,
                           }, {
                               name: '仙桃',
                               value: 33
                           }, {
                               name: '天门',
                               value: 69,
                           }, {
                               name: '咸宁',
                               value: 66
                           }, {
                               name: '宜昌',
                               value: 22
                           },{
                                name: '鄂州',
                                value: 51
                           },{
                                name: '恩施',
                                value: 44
                           },{
                                name: '神农架',
                                value: 9
                           }]
                       }]
                   });
           }
   
           var currentIdx = 0;
           showProvince();
           // 使用刚指定的配置项和数据显示图表。
           window.addEventListener("resize", function () {
               myChart.resize();
           });
    }


    // echart_map中国地图
    function echart_map() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('chart_map'));

        var mapName = 'china'
        var data = []
        var toolTipData = [];

        /*获取地图数据*/
        myChart.showLoading();
        var mapFeatures = echarts.getMap(mapName).geoJson.features;
        myChart.hideLoading();
        var geoCoordMap = {
            '福州': [119.4543, 25.9222],
            '长春': [125.8154, 44.2584],
            '重庆': [107.7539, 30.1904],
            '西安': [109.1162, 34.2004],
            '成都': [103.9526, 30.7617],
            '武汉': [113.41, 31.00],
            '北京': [116.4551, 40.2539],
            '北海': [109.314, 21.6211],
            '海口': [110.3893, 19.8516],
            '长沙': [113.019455,28.200103],
            '上海': [121.40, 31.73],
            '内蒙古': [106.82, 39.67],
            '西藏': [86.82, 32.67],
            '云南': [102.82, 24.67],
        };

        var GZData = [
            [{
                name: '武汉'
            }, {
                name: '福州',
                value: 95
            }],
            [{
                name: '武汉'
            }, {
                name: '长春',
                value: 80
            }],
            [{
                name: '武汉'
            }, {
                name: '重庆',
                value: 70
            }],
            [{
                name: '武汉'
            }, {
                name: '西安',
                value: 60
            }],
            [{
                name: '武汉'
            }, {
                name: '成都',
                value: 50
            }],
            [{
                name: '武汉'
            }, {
                name: '成都',
                value: 40
            }],
            [{
                name: '武汉'
            }, {
                name: '北京',
                value: 30
            }],
            [{
                name: '武汉'
            }, {
                name: '北海',
                value: 20
            }],
            [{
                name: '武汉'
            }, {
                name: '海口',
                value: 10
            }],
            [{
                name: '武汉'
            }, {
                name: '上海',
                value: 80
            }],
            [{
                name: '武汉'
            }, {
                name: '内蒙古',
                value: 80
            }],[{
                name: '武汉'
            }, {
                name: '西藏',
                value: 80
            }],[{
                name: '武汉'
            }, {
                name: '云南',
                value: 80
            }]

        ];

        var convertData = function (data) {
            var res = [];
            for (var i = 0; i < data.length; i++) {
                var dataItem = data[i];
                var fromCoord = geoCoordMap[dataItem[0].name];
                var toCoord = geoCoordMap[dataItem[1].name];
                if (fromCoord && toCoord) {
                    res.push({
                        fromName: dataItem[0].name,
                        toName: dataItem[1].name,
                        coords: [fromCoord, toCoord]
                    });
                }
            }
            return res;
        };

        var color = ['#c5f80e'];
        var series = [];
        [
            ['武汉', GZData]
        ].forEach(function (item, i) {
            series.push({
                name: item[0],
                type: 'lines',
                zlevel: 2,
                symbol: ['none', 'arrow'],
                symbolSize: 10,
                effect: {
                    show: true,
                    period: 6,
                    trailLength: 0,
                    symbol: 'arrow',
                    symbolSize: 5
                },
                lineStyle: {
                    normal: {
                        color: color[i],
                        width: 1,
                        opacity: 0.6,
                        curveness: 0.2
                    }
                },
                data: convertData(item[1])
            }, {
                name: item[0],
                type: 'effectScatter',
                coordinateSystem: 'geo',
                zlevel: 2,
                rippleEffect: {
                    brushType: 'stroke'
                },
                label: {
                    normal: {
                        show: true,
                        position: 'right',
                        formatter: '{b}'
                    }
                },
                symbolSize: function (val) {
                    return val[2] / 8;
                },
                itemStyle: {
                    normal: {
                        color: color[i]
                    }
                },
                data: item[1].map(function (dataItem) {
                    return {
                        name: dataItem[1].name,
                        value: geoCoordMap[dataItem[1].name].concat([dataItem[1].value])
                    };
                })
            });
        });

        option = {
            tooltip: {
                trigger: 'item'
            },
            geo: {
                map: 'china',
                label: {
                    emphasis: {
                        show: false
                    }
                },
                roam: true,
                itemStyle: {
                    normal: {
                        borderColor: 'rgba(147, 235, 248, 1)',
                        borderWidth: 1,
                        areaColor: {
                            type: 'radial',
                            x: 0.5,
                            y: 0.5,
                            r: 0.8,
                            colorStops: [{
                                offset: 0,
                                color: 'rgba(175,238,238, 0)' // 0% 处的颜色
                            }, {
                                offset: 1,
                                color: 'rgba(47,79,79, .1)' // 100% 处的颜色
                            }],
                            globalCoord: false // 缺省为 false
                        },
                        shadowColor: 'rgba(128, 217, 248, 1)',
                        // shadowColor: 'rgba(255, 255, 255, 1)',
                        shadowOffsetX: -2,
                        shadowOffsetY: 2,
                        shadowBlur: 10
                    },
                    emphasis: {
                        areaColor: '#389BB7',
                        borderWidth: 0
                    }
                }
            },
            series: series
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize", function () {
            myChart.resize();
        });

    }
    function echart_6() {
        // 基于准备好的dom，初始化echarts图表
        var myChart = echarts.init(document.getElementById('chart_6'));
        var effect = {
            show: true,
            scaleSize: 1,
            period: 30, // 运动周期，无单位，值越大越慢
            color: '#fff',
            shadowColor: 'rgba(220,220,220,0.4)',
            shadowBlur: 5
        };

        function itemStyle(idx) {
            return {
                normal: {
                    color: '#fff',
                    borderWidth: 1,
                    borderColor: ['rgba(30,144,255,1)', 'lime'][idx],
                    lineStyle: {
                        //shadowColor : ['rgba(30,144,255,1)','lime'][idx], //默认透明
                        //shadowBlur: 10,
                        //shadowOffsetX: 0,
                        //shadowOffsetY: 0,
                        type: 'solid'
                    }
                }
            }
        };
        option = {
            color: ['rgba(30,144,255,1)', 'lime'],
            title: {
                text: '',
                subtext: '',
                sublink: '',
                x: 'center',
                textStyle: {
                    color: '#fff'
                }
            },
            tooltip: {
                trigger: 'item',
                formatter: '{b}'
            },
            legend: {
                orient: 'vertical',
                x: '2%',
                y: '3%',
                selectedMode: 'single',
                data: ['八纵通道', '八横通道'],
                textStyle: {
                    color: '#fff'
                }
            },
            toolbox: {
                show: true,
                orient: 'vertical',
                x: 'right',
                y: 'center',
                padding: [0 ,30, 0 ,0],
                feature: {
                    mark: {
                        show: true
                    },
                    dataView: {
                        show: true,
                        readOnly: false
                    },
                    restore: {
                        show: true
                    },
                    saveAsImage: {
                        show: true
                    }
                }
            },
            series: [{
                name: '八纵通道',
                type: 'map',
                roam: true,
                hoverable: false,
                mapType: 'china',
                itemStyle: {
                    normal: {
                        borderColor: 'rgba(100,149,237,1)',
                        borderWidth: 0.5,
                        areaStyle: {
                            color: '#1b1b1b'
                        }
                    }
                },
                data: [],
                markLine: {
                    symbol: ['circle', 'circle'],
                    symbolSize: 1,
                    effect: effect,
                    itemStyle: itemStyle(0),
                    smooth: true,
                    data: [
                        [{
                            name: '北京'
                        }, {
                            name: '哈尔滨'
                        }],
                        [{
                            name: '哈尔滨'
                        }, {
                            name: '满洲里'
                        }],

                        [{
                            name: '沈阳'
                        }, {
                            name: '大连'
                        }],
                        [{
                            name: '大连'
                        }, {
                            name: '烟台'
                        }],
                        [{
                            name: '烟台'
                        }, {
                            name: '青岛'
                        }],
                        [{
                            name: '青岛'
                        }, {
                            name: '淮安'
                        }],
                        [{
                            name: '淮安'
                        }, {
                            name: '上海'
                        }],
                        [{
                            name: '上海'
                        }, {
                            name: '杭州'
                        }],
                        [{
                            name: '杭州'
                        }, {
                            name: '宁波'
                        }],
                        [{
                            name: '宁波'
                        }, {
                            name: '温州'
                        }],
                        [{
                            name: '温州'
                        }, {
                            name: '福州'
                        }],
                        [{
                            name: '福州'
                        }, {
                            name: '厦门'
                        }],
                        [{
                            name: '厦门'
                        }, {
                            name: '广州'
                        }],
                        [{
                            name: '广州'
                        }, {
                            name: '湛江'
                        }],

                        [{
                            name: '北京'
                        }, {
                            name: '天津'
                        }],
                        [{
                            name: '天津'
                        }, {
                            name: '济南'
                        }],
                        [{
                            name: '济南'
                        }, {
                            name: '南京'
                        }],
                        [{
                            name: '南京'
                        }, {
                            name: '上海'
                        }],

                        [{
                            name: '北京'
                        }, {
                            name: '南昌'
                        }],
                        [{
                            name: '南昌'
                        }, {
                            name: '深圳'
                        }],
                        [{
                            name: '深圳'
                        }, {
                            name: '九龙红磡'
                        }],

                        [{
                            name: '北京'
                        }, {
                            name: '郑州'
                        }],
                        [{
                            name: '郑州'
                        }, {
                            name: '武汉'
                        }],
                        [{
                            name: '武汉'
                        }, {
                            name: '广州'
                        }],

                        [{
                            name: '大同'
                        }, {
                            name: '太原'
                        }],
                        [{
                            name: '太原'
                        }, {
                            name: '焦作'
                        }],
                        [{
                            name: '焦作'
                        }, {
                            name: '洛阳'
                        }],
                        [{
                            name: '洛阳'
                        }, {
                            name: '柳州'
                        }],
                        [{
                            name: '柳州'
                        }, {
                            name: '湛江'
                        }],

                        [{
                            name: '包头'
                        }, {
                            name: '西安'
                        }],
                        [{
                            name: '西安'
                        }, {
                            name: '重庆'
                        }],
                        [{
                            name: '重庆'
                        }, {
                            name: '贵阳'
                        }],
                        [{
                            name: '贵阳'
                        }, {
                            name: '柳州'
                        }],
                        [{
                            name: '柳州'
                        }, {
                            name: '南宁'
                        }],

                        [{
                            name: '兰州'
                        }, {
                            name: '成都'
                        }],
                        [{
                            name: '成都'
                        }, {
                            name: '昆明'
                        }]
                    ]
                }
            },
                {
                    name: '八横通道',
                    type: 'map',
                    mapType: 'china',
                    itedmStyle: {
                        normal: {
                            borderColor: 'rgba(100,149,237,1)',
                            borderWidth: 0.5,
                            areaStyle: {
                                color: '#1b1b1b'
                            }
                        }
                    },
                    data: [],
                    markLine: {
                        symbol: ['circle', 'circle'],
                        symbolSize: 1,
                        effect: effect,
                        itemStyle: itemStyle(1),
                        smooth: true,
                        data: [
                            [{
                                name: '北京'
                            }, {
                                name: '兰州'
                            }],
                            [{
                                name: '兰州'
                            }, {
                                name: '拉萨'
                            }],

                            [{
                                name: '大同'
                            }, {
                                name: '秦皇岛'
                            }],

                            [{
                                name: '神木'
                            }, {
                                name: '黄骅'
                            }],

                            [{
                                name: '太原'
                            }, {
                                name: '德州'
                            }],
                            [{
                                name: '德州'
                            }, {
                                name: '龙口'
                            }],
                            [{
                                name: '龙口'
                            }, {
                                name: '烟台'
                            }],

                            [{
                                name: '太原'
                            }, {
                                name: '德州'
                            }],
                            [{
                                name: '德州'
                            }, {
                                name: '济南'
                            }],
                            [{
                                name: '济南'
                            }, {
                                name: '青岛'
                            }],

                            [{
                                name: '长治'
                            }, {
                                name: '邯郸'
                            }],
                            [{
                                name: '邯郸'
                            }, {
                                name: '济南'
                            }],
                            [{
                                name: '济南'
                            }, {
                                name: '青岛'
                            }],

                            [{
                                name: '瓦塘'
                            }, {
                                name: '临汾'
                            }],
                            [{
                                name: '临汾'
                            }, {
                                name: '长治'
                            }],
                            [{
                                name: '长治'
                            }, {
                                name: '汤阴'
                            }],
                            [{
                                name: '汤阴'
                            }, {
                                name: '台前'
                            }],
                            [{
                                name: '台前'
                            }, {
                                name: '兖州'
                            }],
                            [{
                                name: '兖州'
                            }, {
                                name: '日照'
                            }],

                            [{
                                name: '侯马'
                            }, {
                                name: '月山'
                            }],
                            [{
                                name: '月山'
                            }, {
                                name: '新乡'
                            }],
                            [{
                                name: '新乡'
                            }, {
                                name: '兖州'
                            }],
                            [{
                                name: '兖州'
                            }, {
                                name: '日照'
                            }],

                            [{
                                name: '连云港'
                            }, {
                                name: '郑州'
                            }],
                            [{
                                name: '郑州'
                            }, {
                                name: '兰州'
                            }],
                            [{
                                name: '兰州'
                            }, {
                                name: '乌鲁木齐'
                            }],
                            [{
                                name: '乌鲁木齐'
                            }, {
                                name: '阿拉山口'
                            }],

                            [{
                                name: '西安'
                            }, {
                                name: '南阳'
                            }],
                            [{
                                name: '南阳'
                            }, {
                                name: '信阳'
                            }],
                            [{
                                name: '信阳'
                            }, {
                                name: '合肥'
                            }],
                            [{
                                name: '合肥'
                            }, {
                                name: '南京'
                            }],
                            [{
                                name: '南京'
                            }, {
                                name: '启东'
                            }],

                            [{
                                name: '重庆'
                            }, {
                                name: '武汉'
                            }],
                            [{
                                name: '武汉'
                            }, {
                                name: '九江'
                            }],
                            [{
                                name: '九江'
                            }, {
                                name: '铜陵'
                            }],
                            [{
                                name: '铜陵'
                            }, {
                                name: '南京'
                            }],
                            [{
                                name: '南京'
                            }, {
                                name: '上海'
                            }],

                            [{
                                name: '上海'
                            }, {
                                name: '怀化'
                            }],
                            [{
                                name: '怀化'
                            }, {
                                name: '重庆'
                            }],
                            [{
                                name: '重庆'
                            }, {
                                name: '成都'
                            }],
                            [{
                                name: '成都'
                            }, {
                                name: '贵阳'
                            }],
                            [{
                                name: '贵阳'
                            }, {
                                name: '昆明'
                            }],

                            [{
                                name: '昆明'
                            }, {
                                name: '南宁'
                            }],
                            [{
                                name: '南宁'
                            }, {
                                name: '黎塘'
                            }],
                            [{
                                name: '黎塘'
                            }, {
                                name: '湛江'
                            }]
                        ]
                    },
                    geoCoord: {
                        '阿拉山口': [82.5757, 45.1706],
                        '包头': [109.8403, 40.6574],
                        '北京': [116.4075, 39.9040],
                        '成都': [104.0665, 30.5723],
                        '大连': [121.6147, 38.9140],
                        '大同': [113.3001, 40.0768],
                        '德州': [116.3575, 37.4341],
                        '福州': [119.2965, 26.0745],
                        '广州': [113.2644, 23.1292],
                        '贵阳': [106.6302, 26.6477],
                        '哈尔滨': [126.5363, 45.8023],
                        '邯郸': [114.5391, 36.6256],
                        '杭州': [120.1551, 30.2741],
                        '合肥': [117.2272, 31.8206],
                        '侯马': [111.3720, 35.6191],
                        '怀化': [109.9985, 27.5550],
                        '淮安': [119.0153, 33.6104],
                        '黄骅': [117.3300, 38.3714],
                        '济南': [117.1205, 36.6510],
                        '焦作': [113.2418, 35.2159],
                        '九江': [116.0019, 29.7051],
                        '九龙红磡': [114.1870, 22.3076],
                        '昆明': [102.8329, 24.8801],
                        '拉萨': [91.1409, 29.6456],
                        '兰州': [103.8343, 36.0611],
                        '黎塘': [109.1363, 23.2066],
                        '连云港': [119.2216, 34.5967],
                        '临汾': [111.5190, 36.0880],
                        '柳州': [109.4160, 24.3255],
                        '龙口': [120.4778, 37.6461],
                        '洛阳': [112.4540, 34.6197],
                        '满洲里': [117.3787, 49.5978],
                        '南昌': [115.8581, 28.6832],
                        '南京': [118.7969, 32.0603],
                        '南宁': [108.3661, 22.8172],
                        '南阳': [112.5283, 32.9908],
                        '宁波': [121.5440, 29.8683],
                        '启东': [121.6574, 31.8082],
                        '秦皇岛': [119.6005, 39.9354],
                        '青岛': [120.3826, 36.0671],
                        '日照': [119.5269, 35.4164],
                        '厦门': [118.0894, 24.4798],
                        '上海': [121.4737, 31.2304],
                        '深圳': [114.0579, 22.5431],
                        '神木': [110.4871, 38.8610],
                        '沈阳': [123.4315, 41.8057],
                        '台前': [115.8717, 35.9701],
                        '太原': [112.5489, 37.8706],
                        '汤阴': [114.3572, 35.9218],
                        '天津': [117.2010, 39.0842],
                        '铜陵': [117.8121, 30.9454],
                        '瓦塘': [109.7600, 23.3161],
                        '温州': [120.6994, 27.9943],
                        '乌鲁木齐': [87.6168, 43.8256],
                        '武汉': [114.3054, 30.5931],
                        '西安': [108.9402, 34.3416],
                        '新乡': [113.9268, 35.3030],
                        '信阳': [114.0913, 32.1470],
                        '烟台': [121.4479, 37.4638],
                        '兖州': [116.7838, 35.5531],
                        '月山': [113.0550, 35.2104],
                        '湛江': [110.3594, 21.2707],
                        '长治': [113.1163, 36.1954],
                        '郑州': [113.6254, 34.7466],
                        '重庆': [106.5516, 29.5630]
                    }
                }
            ]
        };

        // 为echarts对象加载数据
        myChart.setOption(option);
    }
    //echart_3货物周转量
    function echart_3() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('chart_3'));
        myChart.clear();
        option = {
            title: {
                text: ''
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:['铁路货物','国家铁路货物','地方铁路货物','合资铁路货物','公路货物','水运货物'],
                textStyle:{
                    color: '#fff'
                },
                top: '8%'
            },
            grid: {
                top: '40%',
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            color: ['#FF4949','#FFA74D','#FFEA51','#4BF0FF','#44AFF0','#4E82FF','#584BFF','#BE4DFF','#F845F1'],
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['2013年','2014年','2015年','2016年','2017年'],
                splitLine: {
                    show: false
                },
                axisLine: {
                    lineStyle: {
                        color: '#fff'
                    }
                }
            },
            yAxis: {
                name: '亿吨公里',
                type: 'value',
                splitLine: {
                    show: false
                },
                axisLine: {
                    lineStyle: {
                        color: '#fff'
                    }
                }
            },
            series: [
                {
                    name:'铁路货物',
                    type:'line',
                    data:[3961.88, 4233.63, 4183.14, 3633.01, 3704.47]
                },
                {
                    name:'国家铁路货物',
                    type:'line',
                    data:[3374.76, 3364.76, 3274.76, 3371.82, 3259.87]
                },
                {
                    name:'地方铁路货物',
                    type:'line',
                    data:[14.77, 15.17, 13.17, 14.56, 15.84]
                },
                {
                    name:'合资铁路货物',
                    type:'line',
                    data:[686.17,847.26,895.22,865.28,886.72]
                },
                {
                    name:'公路货物',
                    type:'line',
                    data:[6133.47, 6577.89, 7019.56,6821.48,7294.59]
                },
                {
                    name:'水运货物',
                    type:'line',
                    data:[509.60, 862.54, 1481.77,1552.79,1333.62]
                }
            ]
        };
        myChart.setOption(option);
    }

    function echart_7(){
        var myChart = echarts.init(document.getElementById('chart_7'));
        myChart.clear();

        option = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                top: '2%',
                left: '1%',
                textStyle: {
                    color: '#fff'
                },
                data:[
                    '国际','省外','省内',
                ]
            },
            color: ['#FF4949','#FFA74D','#4BF0FF','#44AFF0','#4E82FF','#584BFF','#BE4DFF','#F845F1','#4BF0FF','#44AFF0'],
            series: [
                {
                    name:'业务量(万件)',
                    type:'pie',
                    selectedMode: 'single',
                    radius: [0, '15%'],
                    center: ['28%','28%'],
                    label: {
                        normal: {
                            position: 'inner'
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data:[
                        {value:90392.39, name:'2018年业务量(90392.39万件)'},
                    ]
                },
                {
                    name:'业务量(万件)',
                    type:'pie',
                    radius: ['20%', '30%'],
                    center: ['28%','28%'],
                    label: {
                        normal: {
                            formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
                            backgroundColor: '#eee',
                            borderColor: '#aaa',
                            borderWidth: 1,
                            borderRadius: 4,
                            rich: {
                                a: {
                                    color: '#999',
                                    lineHeight: 22,
                                    align: 'center'
                                },
                                hr: {
                                    borderColor: '#aaa',
                                    width: '100%',
                                    borderWidth: 0.5,
                                    height: 0
                                },
                                b: {
                                    fontSize: 16,
                                    lineHeight: 33
                                },
                                per: {
                                    color: '#eee',
                                    backgroundColor: '#334455',
                                    padding: [2, 4],
                                    borderRadius: 2
                                }
                            }
                        }
                    },
                    data:[
                        {value:464.43, name:'国际'},
                        {value:68575.6, name:'省外'},
                        {value:21352.36, name:'省内'},
                    ]
                },
                {
                    name:'业务量(万件)',
                    type:'pie',
                    selectedMode: 'single',
                    radius: [0, '15%'],
                    center: ['70%','28%'],
                    label: {
                        normal: {
                            position: 'inner'
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data:[
                        {value:54911.94, name:'2017年业务量(54911.94万件)'},
                    ]
                },
                {
                    name:'业务量(万件)',
                    type:'pie',
                    radius: ['20%', '30%'],
                    center: ['70%','28%'],
                    label: {
                        normal: {
                            formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
                            backgroundColor: '#eee',
                            borderColor: '#aaa',
                            borderWidth: 1,
                            borderRadius: 4,
                            rich: {
                                a: {
                                    color: '#999',
                                    lineHeight: 22,
                                    align: 'center'
                                },
                                hr: {
                                    borderColor: '#aaa',
                                    width: '100%',
                                    borderWidth: 0.5,
                                    height: 0
                                },
                                b: {
                                    fontSize: 16,
                                    lineHeight: 33
                                },
                                per: {
                                    color: '#eee',
                                    backgroundColor: '#334455',
                                    padding: [2, 4],
                                    borderRadius: 2
                                }
                            }
                        }
                    },
                    data:[
                        {value:278.5, name:'国际'},
                        {value:37111.03, name:'省外'},
                        {value:17522.41, name:'省内'},
                    ]
                },
                {
                    name:'业务量(万件)',
                    type:'pie',
                    selectedMode: 'single',
                    radius: [0, '15%'],
                    center: ['28%','70%'],
                    label: {
                        normal: {
                            position: 'inner'
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data:[
                        {value:34019.15, name:'2016年业务量(34019.15万件)'},
                    ]
                },
                {
                    name:'业务量(万件)',
                    type:'pie',
                    radius: ['20%', '30%'],
                    center: ['28%','70%'],
                    label: {
                        normal: {
                            formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
                            backgroundColor: '#eee',
                            borderColor: '#aaa',
                            borderWidth: 1,
                            borderRadius: 4,
                            rich: {
                                a: {
                                    color: '#999',
                                    lineHeight: 22,
                                    align: 'center'
                                },
                                hr: {
                                    borderColor: '#aaa',
                                    width: '100%',
                                    borderWidth: 0.5,
                                    height: 0
                                },
                                b: {
                                    fontSize: 16,
                                    lineHeight: 33
                                },
                                per: {
                                    color: '#eee',
                                    backgroundColor: '#334455',
                                    padding: [2, 4],
                                    borderRadius: 2
                                }
                            }
                        }
                    },
                    data:[
                        {value:163.72, name:'国际'},
                        {value:26841.29, name:'省外'},
                        {value:7014.14, name:'省内'},
                    ]
                },
                {
                    name:'业务量(万件)',
                    type:'pie',
                    selectedMode: 'single',
                    radius: [0, '15%'],
                    center: ['70%','70%'],
                    label: {
                        normal: {
                            position: 'inner'
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data:[
                        {value:20755.74, name:'2015年业务量(20755.74万件)'},
                    ]
                },
                {
                    name:'业务量(万件)',
                    type:'pie',
                    radius: ['20%', '30%'],
                    center: ['70%','70%'],
                    label: {
                        normal: {
                            formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
                            backgroundColor: '#eee',
                            borderColor: '#aaa',
                            borderWidth: 1,
                            borderRadius: 4,
                            rich: {
                                a: {
                                    color: '#999',
                                    lineHeight: 22,
                                    align: 'center'
                                },
                                hr: {
                                    borderColor: '#aaa',
                                    width: '100%',
                                    borderWidth: 0.5,
                                    height: 0
                                },
                                b: {
                                    fontSize: 16,
                                    lineHeight: 33
                                },
                                per: {
                                    color: '#eee',
                                    backgroundColor: '#334455',
                                    padding: [2, 4],
                                    borderRadius: 2
                                }
                            }
                        }
                    },
                    data:[
                        {value:129.65, name:'国际'},
                        {value:18072.54, name:'省外'},
                        {value:2553.55, name:'省内'},
                    ]
                },
            ]
        };

        myChart.setOption(option);
    }

    function echart_9() {
        var myChart = echarts.init(document.getElementById('chart_9'));
        myChart.clear();
        option = {
            title: {
                text: ''
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data:['铁路营业里程','公路里程','等级公路里程','高速等级公路里程','一级等级公路里程','二级等级公路里程','等外公路公路里程'],
                textStyle:{
                    color: '#fff'
                },
                top: '4%'
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            toolbox: {
                orient: 'vertical',
                right: '1%',
                top: '2%',
                iconStyle: {
                    color: '#FFEA51',
                    borderColor: '#FFA74D',
                    borderWidth: 1,
                },
                feature: {
                    saveAsImage: {},
                    magicType: {
                        show: true,
                        type: ['line','bar','stack','tiled']
                    }
                }
            },
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: ['2014年','2015年','2016年','2017年','2018年'],
                splitLine: {
                    show: false
                },
                axisLine: {
                    lineStyle: {
                        color: '#fff'
                    }
                }
            },
            yAxis: {
                name: '万公里',
                type: 'value',
                splitLine: {
                    show: false
                },
                axisLine: {
                    lineStyle: {
                        color: '#fff'
                    }
                }
            },
            color: ['#FF4949','#FFA74D','#FFEA51','#4BF0FF','#44AFF0','#4E82FF','#584BFF','#BE4DFF','#F845F1'],
            series: [
                {
                    name:'铁路营业里程',
                    type:'line',
                    data:[0.56, 0.63, 0.63, 0.70, 0.70]
                },
                {
                    name:'公路里程',
                    type:'line',
                    data:[16.30, 17.45, 17.92, 18.46, 18.84]
                },
                {
                    name:'等级公路里程',
                    type:'line',
                    data:[15.54, 16.77, 17.29, 17.86, 18.26]
                },
                {
                    name:'高速等级公路里程',
                    type:'line',
                    data:[0.51, 0.56, 0.59, 0.63, 0.65]
                },
                {
                    name:'一级等级公路里程',
                    type:'line',
                    data:[0.47,0.48,0.51,0.54,0.56]
                },
                {
                    name:'二级等级公路里程',
                    type:'line',
                    data:[1.76, 1.85, 1.93, 1.97, 1.99]
                },
                {
                    name:'等外公路公路里程',
                    type:'line',
                    data:[0.76, 0.68, 0.63, 0.60, 0.58]
                }
            ]
        };
        myChart.setOption(option);
    }
    //湖南省飞机场

    //点击跳转
    // $('#chart_map').click(function(){
    //     window.location.href = './page/tran.html';
    // });
    // $('.t_btn2').click(function(){
    //     window.location.href = "./page/tran.html?id=2";
    // });
    // $('.t_btn3').click(function(){
    //     window.location.href = "./page/tran.html?id=3";
    // });
    // $('.t_btn4').click(function(){
    //     window.location.href = "./page/tran.html?id=4";
    // });
    // $('.t_btn5').click(function(){
    //     window.location.href = "./page/tran.html?id=5";
    // });
    // $('.t_btn6').click(function(){
    //     window.location.href = "./page/tran.html?id=6";
    // });
    // $('.t_btn7').click(function(){
    //     window.location.href = "./page/tran.html?id=7";
    // });
    // $('.t_btn8').click(function(){
    //     window.location.href = "./page/tran.html?id=8";
    // });
    // $('.t_btn9').click(function(){
    //     window.location.href = "./page/tran.html?id=9";
    // });
});
