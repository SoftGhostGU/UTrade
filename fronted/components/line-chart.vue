<template>
	<div id="main" style="width: 100%; height:150%;"></div>
</template>

<script>
	import * as echarts from 'echarts';

	export default {
		name: 'LineChart',
		mounted() {
			this.initChart();
		},
		methods: {
			initChart() {
				const chartDom = document.getElementById('main');
				const myChart = echarts.init(chartDom);
				const option = {
					xAxis: {
						type: 'category',
						data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
					},
					yAxis: {
						type: 'value'
					},
					series: [{
						data: [820, 932, 901, 934, 1290, 1330, 1320],
						type: 'line',
						smooth: true
					}]
				};

				option && myChart.setOption(option);
			}
		}
	};
</script>

<style>
	
</style>