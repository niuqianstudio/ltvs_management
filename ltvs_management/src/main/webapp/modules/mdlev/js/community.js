/**
 * 小区信息
 */
window.onload = function () {
    $solway.zoom({
        ele: document.getElementById('container'),
        scale: 1,
        minScale: 0.1,
        rate: 0.1
    });
    $solway.drag({
        ele: document.getElementById('container')
    });
};
//弹窗控件
var layer = null;
layui.use('layer', function () {
    layer = layui.layer;
});
var getQueryString = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]);
    return null;
}
var MAX_WIDTH = 1500;
var MAX_HEIGHT = 900;
//svg 根元素
var _SVG = SVG('container').size(1200, 800);
//园
var circle = _SVG.defs().circle(10).attr({
    'fill-opacity': 0,
    'stroke': '#000',
    'stroke-width': 1.5
});
// 虚线框
var rect = _SVG.defs().rect(450, 130).attr({
    'fill-opacity': 0,
    'stroke': '#000',
    'stroke-width': 1.5,
    'stroke-dasharray': "5"
});

//基本元素
class Dsvg {
    constructor() { }
    //长方形
    drawRect(x, y, w, h) {
        _SVG.rect(w, h).attr({
            'fill-opacity': 0,
            'stroke': '#000',
            'stroke-width': 1.5
        }).move(x, y);
    }

    //直线段
    drawLine(start1, end1, start2, end2, fn) {
        var l = _SVG.line(start1, end1, start2, end2).attr({
            'fill-opacity': 0,
            'stroke': '#000',
            'stroke-width': 1.5
        }).style("cursor:pointer;");
        if (typeof (fn) == "function") {
            l.on('mouseover', fn);
        }
        return l.node.id;
    }
    // 带颜色线段
    drawLineWithColor(start1, end1, start2, end2, color, fn) {
        var l = _SVG.line(start1, end1, start2, end2).attr({
            'fill-opacity': 0,
            'stroke': color,
            'stroke-width': 1.5
        }).style("cursor:pointer;");
        if (typeof (fn) == "function") {
            l.on('mouseover', fn);
        }
        return l.node.id;;
    }
    //带底部文字的图片
    drawImg(path, x, y, text, fn, type) {
        var img = _SVG.image(path).loaded(function (loader) {
            this.size(loader.width, loader.height);
            (function () {
                _SVG.text(text).attr({
                    "font-weight": "normal",
                    "font-family": "Helvetica, Arial, sans-serif",
                    "font-size": 12
                }).move(x, y + loader.height);
            })();
        }).move(x, y).style("cursor:pointer;");
        if (type != null || type != undefined) {
            if (typeof (fn) == "function") {
                img.on(type, fn);
            }
        } else {
            if (typeof (fn) == "function") {
                img.on('mouseover', fn);
            }
        }

        return img.node.id;
    }
    //文字 默认大小为12
    drawText(x, y, text) {
        _SVG.text(text).attr({
            "font-weight": "normal",
            "font-family": "Helvetica, Arial, sans-serif",
            "font-size": 12
        }).move(x, y);
    }

}
class Lgsvg {
    constructor() { }
    drawCommunity(mc) {
        var dsvg = new Dsvg();
        dsvg.drawImg("img/dianbiaoxiang.svg", 50, 50, mc, null);
        var n = dsvg.drawLineWithColor(55, 113, 55, 745, "#0000FF", () => {
            // layer.tips('A相', '#' + a, {
            //     tips: [4, '#DAA520']
            // });
        });
        var a = dsvg.drawLineWithColor(65, 113, 65, 745, "#DAA520", () => {
            layer.tips('A相', '#' + a, {
                tips: [4, '#DAA520']
            });
        });
        var b = dsvg.drawLineWithColor(75, 113, 75, 745, "#3CB371", () => {
            layer.tips('B相', '#' + b, {
                tips: [4, '#3CB371']
            });
        });
        var c = dsvg.drawLineWithColor(85, 113, 85, 745, "#8B0000", () => {
            layer.tips('C相', '#' + c, {
                tips: [4, '#8B0000']
            });
        });
    }
    drawElectricA(x, alist) {
        var length = alist.length;
        var dsvg = new Dsvg();
        for (var i = 0; i < Math.floor(length / 20) + 1; i++) {
            dsvg.drawLineWithColor(65, 125 + (i * 85), 85, 125 + (i * 85), '#DAA520');
        }
        var t = 0;
        for (var i = 0; i < length; i++) {
            t = i - Math.floor(i / 20) * 20;
            dsvg.drawLineWithColor(105 + (t * 50) + x - 20, 50 + Math.floor(i / 20) * 85 + 75, 155 + (t * 50) + x - 20, 50 + Math.floor(i / 20) * 85 + 75, '#DAA520');
            dsvg.drawLine(130 + (t * 50) + x - 20, 50 + Math.floor(i / 20) * 85 + 75, 130 + (t * 50) + x - 20, 75 + Math.floor(i / 20) * 85 + 75);
            (function (i) {
                var imgid = dsvg.drawImg("img/hu.svg", 115 + (t * 50) + x - 20, 75 + Math.floor(i / 20) * 85 + 75, alist[i].dbbs, () => {
                    layer.tips(alist[i].dbbs, '#' + imgid, {
                        tips: [1, '#DAA520']
                    });
                });
            })(i);
        }
        return Math.floor(i / 20) + 1;
    }
    drawElectricB(x, blist, lev) {
        var length = blist.length;
        var dsvg = new Dsvg();
        for (var i = 0; i < Math.floor(length / 20) + 1; i++) {
            dsvg.drawLineWithColor(75, 125 + (i + lev) * 85, 85, 125 + (i + lev) * 85, '#3CB371');
        }
        var t = 0;
        for (var i = 0; i < length; i++) {
            t = i - Math.floor(i / 20) * 20;
            dsvg.drawLineWithColor(105 + (t * 50) + x - 20, 50 + Math.floor(i / 20) * 85 + 75 + lev * 85, 155 + (t * 50) + x - 20, 50 + Math.floor(i / 20) * 85 + 75 + lev * 85, '#3CB371');
            dsvg.drawLine(130 + (t * 50) + x - 20, 50 + Math.floor(i / 20) * 85 + 75 + lev * 85, 130 + (t * 50) + x - 20, 75 + Math.floor(i / 20) * 85 + 75 + lev * 85);
            (function (i) {
                var imgid = dsvg.drawImg("img/hu.svg", 115 + (t * 50) + x - 20, 75 + Math.floor(i / 20) * 85 + 75 + lev * 85, blist[i].dbbs, () => {
                    layer.tips(blist[i].dbbs, '#' + imgid, {
                        tips: [1, '#3CB371']
                    });
                });
            })(i);
        }
        return Math.floor(i / 20) + 1;
    }
    drawElectricC(x, clist, lev) {
        var length = clist.length;
        var dsvg = new Dsvg();
        var t = 0;
        for (var i = 0; i < length; i++) {
            t = i - Math.floor(i / 20) * 20;
            dsvg.drawLineWithColor(105 + (t * 50) + x - 20, 50 + Math.floor(i / 20) * 85 + 75 + lev * 85, 155 + (t * 50) + x - 20, 50 + Math.floor(i / 20) * 85 + 75 + lev * 85, '#8B0000');
            dsvg.drawLine(130 + (t * 50) + x - 20, 50 + Math.floor(i / 20) * 85 + 75 + lev * 85, 130 + (t * 50) + x - 20, 75 + Math.floor(i / 20) * 85 + 75 + lev * 85);
            (function (i) {
                var imgid = dsvg.drawImg("img/hu.svg", 115 + (t * 50) + x - 20, 75 + Math.floor(i / 20) * 85 + 75 + lev * 85, clist[i].dbbs, () => {
                    layer.tips(clist[i].dbbs, '#' + imgid, {
                        tips: [1, '#8B0000']
                    });
                });
            })(i);
        }
        return Math.floor(i / 20) + 1;
    }
    drawElectricABC(x, clist, lev) {
        var length = clist.length;
        var dsvg = new Dsvg();
        var t = 0;
        for (var i = 0; i < length; i++) {
            t = i - Math.floor(i / 20) * 20;
            dsvg.drawLineWithColor(105 + (t * 50) + x - 20, 50 + Math.floor(i / 20) * 85 + 75 + lev * 85, 155 + (t * 50) + x - 20, 50 + Math.floor(i / 20) * 85 + 75 + lev * 85, '#000000');
            dsvg.drawLine(130 + (t * 50) + x - 20, 50 + Math.floor(i / 20) * 85 + 75 + lev * 85, 130 + (t * 50) + x - 20, 75 + Math.floor(i / 20) * 85 + 75 + lev * 85);
            (function (i) {
                var imgid = dsvg.drawImg("img/hu.svg", 115 + (t * 50) + x - 20, 75 + Math.floor(i / 20) * 85 + 75 + lev * 85, clist[i].dbbs, () => {
                    layer.tips(clist[i].dbbs, '#' + imgid, {
                        tips: [1, '#000000']
                    });
                });
            })(i);
        }
    }
}
class DataUtil {
    constructor() { }
    queryData(url, parm) {
        var nodeList = null;
        $.ajax({
            url: url,
            data: parm,
            async: false,
            error: function () {
                console.log('查询信息失败');
            }
        }).done(function (res) {
            nodeList = eval('(' + res + ')');
        });
        return nodeList;
    }
}
$(document).ready(function () {
    var pdxbh = getQueryString("pdxbh");
    if(pdxbh == "pdx005"){
        $("#container").html('<img width="800" height="600" src="img/left3.jpg"/>');
        return;
    }else if(pdxbh == "pdx006"){
        $("#container").html('<img width="800" height="600" src="img/right2.jpg"/>');
        return;
    }
    var pdxmc = getQueryString("pdxmc");
    var dataUtil = new DataUtil();
    var dbList = dataUtil.queryData("/ltvs_management/getDbById", { "dbxId": pdxbh });
    var aList = [];
    var bList = [];
    var cList = [];
    var dList = [];
    for (var i = 0; i < dbList.length; i++) {
        if (dbList[i].xwdm == "1") {
            aList.push(dbList[i]);
        } else if (dbList[i].xwdm == "2") {
            bList.push(dbList[i]);
        } else if (dbList[i].xwdm == "3") {
            cList.push(dbList[i])
        } else if (dbList[i].xwdm == "4") {
            dList.push(dbList[i])
        }
    }

    _SVG.text(pdxmc).attr({
        "font-weight": "bold",
        "font-family": "Helvetica, Arial, sans-serif",
        "font-size": 16
    }).move(20, 20);
    var lgsvg = new Lgsvg();
    lgsvg.drawCommunity(pdxmc);
    var t1 = lgsvg.drawElectricA(0, aList);
    var t2 = lgsvg.drawElectricB(0, bList, t1);
    var t3 = lgsvg.drawElectricC(0, cList, t2 + t1);
    lgsvg.drawElectricABC(0, dList, t1 + t2 + t3);
});