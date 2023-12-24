function lineCharts(){
    //mychart();

     createPieChart("myAnxietyLineChart","line", weeklyChartLabels, anxietyChartData, "Anxiety");
     createPieChart("myDepressionLineChart","line",weeklyChartLabels,depressionChartData);
     createPieChart("myEnergyLevelLineGraph","line", weeklyChartLabels,energyLevelChartData);
     createPieChart("myCravingLevelLineGraph", "line", weeklyChartLabels,cravingLevelChartData);
     createPieChart("mySelfHarmLevelLineGraph","line", weeklyChartLabels,selfHarmChartData);
     createPieChart("myImpulseLevelLineGraph", "line", weeklyChartLabels,impulseLevelChartData);
}
var myAnxietyPieChart, myDepressionBarChart, myEnergyLevelLineGraph, myCravingLevelLineGraph, mySelfHarmLevelLineGraph, myImpulseLevelLineGraph;

function thrityChart(){
    myAnxietyPieChart = createPieChart("myAnxietyPieChart","line", weeklyChartLabels, anxietyChartData, "Anxiety");
    myDepressionBarChart = createPieChart("myDepressionLineChart","line",weeklyChartLabels,depressionChartData, "Depression");
    myEnergyLevelLineGraph = createPieChart("myEnergyLevelLineGraph","line", weeklyChartLabels,energyLevelChartData, "Energy Level");
    myCravingLevelLineGraph = createPieChart("myCravingLevelLineGraph", "line", weeklyChartLabels,cravingLevelChartData, "Craving Level");
    mySelfHarmLevelLineGraph = createPieChart("mySelfHarmLevelLineGraph", "line", weeklyChartLabels,selfHarmChartData, "Self Harm Level");
    myImpulseLevelLineGraph = createPieChart("myImpulseLevelLineGraph", "line", weeklyChartLabels,impulseLevelChartData, "Impulse Level");
}

var aPieChart, depressionPieChart, energyLevelPieChart, cravingLevelPieChart, selfHarmLevelPieChart,impulseLevelPieChart;
function overview(){
   aPieChart = createPieChart("myAnxietyPieChart","pie",weeklyChartLabels,anxietyChartData,"Anxiety");
   depressionPieChart = createPieChart("myDepressionPieChart","pie",weeklyChartLabels,depressionChartData,"Depression");
   energyLevelPieChart = createPieChart("myEnergyLevelPieChart","pie",weeklyChartLabels,energyLevelChartData,"Energy Level");
   cravingLevelPieChart = createPieChart("myCravingLevelPieChart","pie",weeklyChartLabels,cravingLevelChartData,"Craving Level");
   selfHarmLevelPieChart = createPieChart("mySelfHarmLevelPieChart","pie",weeklyChartLabels,selfHarmChartData,"Self Harm Level");
   impulseLevelPieChart = createPieChart("myImpulseLevelPieChart","pie",weeklyChartLabels,impulseLevelChartData,"Impulse Level");
}

function createPieChart(elementId, type, labels, data, datasetLabel) {
    var ctx = document.getElementById(elementId).getContext('2d');
    return new Chart(ctx, {
        type: type,
        data: {
            labels: labels,
            datasets: [{
                label: datasetLabel,
                data: data
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false
        }
    });
}
// function pieChart(){
//     createPieChart("myAnxietyPieChart", "myAnxietyPieChart","line", weeklyChartLabels, anxietyChartData, "Anxiety");
//     createPieChart("myDepressionLineChart","myDepressionBarChart","line",weeklyChartLabels,depressionChartData);
//     createPieChart("myEnergyLevelLineGraph", "myEnergyLevelLineGraph", "line", weeklyChartLabels,energyLevelChartData);
//     createPieChart("myCravingLevelLineGraph", "myCravingLevelLineGraph", "line", weeklyChartLabels,cravingLevelChartData);
//     createPieChart("mySelfHarmLevelLineGraph", "mySelfHarmLevelLineGraph", "line", weeklyChartLabels,selfHarmChartData);
//     createPieChart("myImpulseLevelLineGraph", "myImpulseLevelLineGraph", "line", weeklyChartLabels,impulseLevelChartData);
// }
//
//
//
// function createPieChart(elementId, type, labels, data, datasetLabel) {
//
//     var ctx = document.getElementById(elementId).getContext('2d');
//     return new Chart(ctx, {
//         type: type,
//         data: {
//             labels: labels,
//             datasets: [
//                 {
//                 label: datasetLabel,
//                 data: data
//             },
//
//             ]
//         },
//         options: { responsive:true,
//                     maintainAspectRatio: false}
//     });
// }



function mychart(){
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: anxietyChartLabels,
            datasets: [
                {
                    label: 'Anxiety Level',
                    data: anxietyChartData,
                    borderColor: 'rgba(255, 99, 132, 1)',
                    fill: false,
                },
                {
                    label: 'Depression Level',
                    data: depressionChartData,
                    borderColor: 'rgba(54, 162, 235, 1)',
                    fill: false,
                },
                {
                    label: 'Energy Level',
                    data: energyLevelChartData,
                    borderColor: 'rgba(75, 192, 192, 1)',
                    fill: false,
                },
                {
                    label:'Craving Level',
                    data:cravingLevelChartData,
                    borderColor: 'rgba(0, 0, 0, 1)'
                },
                {
                    label:'Self Harm Level',
                    data:selfHarmChartData,
                    borderColor: 'rgba(128, 128, 128, 1)'
                },
                {
                    label:'Impulse Level',
                    data:impulseLevelChartData,
                    borderColor: 'rgba(25, 25, 112, 1)'
                }
            ]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                x: {
                    display: true,
                    title: {
                        display: true,
                        text: 'Month'
                    }
                },
                y: {
                    display: true,
                    title: {
                        display: true,
                        text: 'Value'
                    }
                }
            }
        }
    });
}

