    //load the package gauge from googlechart and invoke drawGuage method as setOnLoadCallback
    google.charts.load('current', {'packages':['gauge']});
    google.charts.setOnLoadCallback(drawGauge);
    //establish the pie chart parameters
    var gaugeOptions = {min: 1, max: 6, yellowFrom: 3, yellowTo: 5,
      redFrom: 5, redTo: 6, minorTicks: 5};
    //establish the pie chart parameters
    var gaugeOptionsPlus = {min: 1, max: 12, yellowFrom: 4, yellowTo: 8,
      redFrom: 8, redTo: 12, minorTicks: 5};
    var gauge;
    var gaugePlus;
    var time = 0;
    var totalValue = 0;

    function drawGauge() {
      //initiate two datatable to draw pie chart
      gaugeData = new google.visualization.DataTable();
      gaugeDataPlus = new google.visualization.DataTable();
      //add pie charts in column
      gaugeData.addColumn('number', 'DiceOne');
      gaugeData.addColumn('number', 'DiceTwo');
      gaugeData.addRows(1);
      //set initial value on pie chart
      gaugeData.setCell(0, 0, 6);
      gaugeData.setCell(0, 1, 6);
      //add pie charts in column
      gaugeDataPlus.addColumn('number', 'DiceThree');
      gaugeDataPlus.addColumn('number', 'DiceFour');
      gaugeDataPlus.addRows(1);
      //set initial value on pie chart
      gaugeDataPlus.setCell(0, 0, 6);
      //draw pie chart in the specific div
      gauge = new google.visualization.Gauge(document.getElementById('gauge_div'));
      gaugePlus = new google.visualization.Gauge(document.getElementById('gauge_div_plus'));
      gauge.draw(gaugeData, gaugeOptions);
      gaugePlus.draw(gaugeDataPlus,gaugeOptionsPlus);
    }
 
    function changeTemp(dice1,dice2) {
      //record total times of data subscribed
      time+=2;
      //set value on pie chart and draw in setting format
      gaugeData.setValue(0, 0, dice1);
      gaugeData.setValue(0, 1, dice2);
      gauge.draw(gaugeData, gaugeOptions);
      //set value on pie chart and draw in setting format
      gaugeDataPlus.setValue(0, 0, dice1+dice2);
      //obtain the total sum of two dices
      totalValue+=(dice1+dice2);
      gaugeDataPlus.setValue(0, 1, totalValue/time);
      gaugePlus.draw(gaugeDataPlus,gaugeOptionsPlus);
    }