/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import google line chart package
google.charts.load('current', {'packages':['line']});
//specify the defined format
var options = {
          title: 'DiceRolling Possibility',
          //wheather curve,make line smooth
          curveType: 'function',
          legend: { position: 'bottom' },
          //set the bound
          vAxis: {
                format: 'percent',
                minValue: 0,
                maxValue: 1
          }
};
//create one map to store the appearance times of dice rolling
var map = new Map();
var timesCount = 0;
for(var i=2;i<=12;i++){
    map.set(i,0);
}
var data;

function changeLineChart(dice1,dice2){
    timesCount++;
    //set the value from subscriber into map
    map.set(dice1+dice2,map.get(dice1+dice2)+1);
    //generate one line chart table
    data = new google.visualization.DataTable();
    //add specific column and row into this datatable
    data.addColumn('number', 'sumValue');
    data.addColumn('number', 'quantities');
    //insert rows by obtain the value of map
    data.addRows([[2,map.get(2)/timesCount],
                  [3,map.get(3)/timesCount],
                  [4,map.get(4)/timesCount],
                  [5,map.get(5)/timesCount],
                  [6,map.get(6)/timesCount],
                  [7,map.get(7)/timesCount],
                  [8,map.get(8)/timesCount],
                  [9,map.get(9)/timesCount],
                  [10,map.get(10)/timesCount],
                  [11,map.get(11)/timesCount],
                  [12,map.get(12)/timesCount],]);
    //draw and put this chart into specific div 
    var chart = new google.charts.Line(document.getElementById('lineChart_div'));
    chart.draw(data,options);
}