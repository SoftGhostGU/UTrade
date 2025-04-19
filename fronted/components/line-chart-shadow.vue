<template>
	<view>
		<div id="main" style="width: 100%; height:100%;"></div>
	</view>
</template>

<script>
	import * as echarts from 'echarts';

	export default {
		name: "line-chart-shadow",
		mounted() {
			this.initChart();
		},
		methods: {
			initChart() {
				var chartDom = document.getElementById('main');
				var myChart = echarts.init(chartDom);

				const option = {
					tooltip: {
						trigger: 'axis',
						axisPointer: {
							type: 'cross',
							label: {
								backgroundColor: '#6a7985'
							}
						}
					},
					// legend: {
					//   data: ['Balance']
					// },
					grid: {
						left: '3%',
						right: '4%',
						bottom: '3%',
						containLabel: false
					},
					xAxis: [{
						type: 'category',
						boundaryGap: false,
						data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
					}],
					yAxis: [{
						type: 'value'
					}],
					series: [{
						name: 'Balance',
						type: 'line',
						stack: 'Total',
						areaStyle: {},
						emphasis: {
							focus: 'series'
						},
						data: [120, 132, 101, 134, 90, 230, 210]
					}, ]
				};

				option && myChart.setOption(option);

			}
		}
	}
</script>

<style>

</style>