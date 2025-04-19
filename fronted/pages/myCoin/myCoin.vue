<template>
	<view class="all">
		<view class="header">
			<view class="previous">
				<img src="/static/previous_icon.png" alt="" class="previous-img" />
			</view>
			<view class="header-title">
				我的时间币
			</view>
		</view>
		<view class="subtitle">
			<view class="subtitle-content active">我的时间币</view>
			<view class="subtitle-content">历史记录</view>
			<view class="subtitle-content">余额</view>
		</view>
		<view class="now-coin">
			<view class="white-box">
				<view class="now-coin-word">
					当前：{{ count }}TB
				</view>
				<view>
					<img src="/static/coin_img.png" alt="coin" class="now-coin-img" />
				</view>
			</view>
		</view>
		<view class="balance-box">
			<view class="balance-box-title">
				近日收支曲线
			</view>
			<lineChartShadow class="balance-line"/>
		</view>
		<!-- <view class="queations-box">

		</view> -->
	</view>
</template>

<script setup>
	import lineChartShadow from "/components/line-chart-shadow.vue"
	
	const count = 500;
</script>

<style scoped>
	.all {
		height: 100vh;
		background: linear-gradient(180deg, #5955dc 0%, #2c2a42 100%);
	}

	.header {
		height: 50px;
		flex: 1;
		display: flex;
		flex-direction: row;
	}

	.previous {
		display: block;
		width: 30px;
		height: 30px;
		margin-top: 20px;
		margin-left: 15px;
		margin-bottom: 10px;
		line-height: 30px;
		text-align: center;
		align-content: center;
	}

	.previous-img {
		width: 30px;
		height: 30px;
	}

	.header-title {
		width: calc(100% - 90px);
		color: white;
		font: bold;
		font-size: 24px;
		font-family: '华文琥珀';
		text-align: center;
		align-content: center;
		line-height: 30px;
		margin-top: 20px;
	}

	.subtitle {
		width: 90%;
		display: flex;
		flex-direction: row;
		margin: 0 auto;
	}

	.subtitle-content {
		margin-top: 15px;
		width: 30%;
		color: #b2b2b2;
		text-align: center;
		font-size: 14px;
	}

	.subtitle-content:nth-child(1) {
		width: 40%;
	}

	.subtitle .active {
		position: relative;
		display: inline-block;
		color: white;
	}

	.subtitle .active::after {
		content: '';
		position: absolute;
		left: 0;
		right: 0;
		bottom: -7px;
		height: 2px;
		background-color: #fff;
		width: 25%;
		margin: 0 auto;
	}

	.now-coin {
		width: 85%;
		height: 100px;
		margin: 30px auto 0px;
		background-color: #7a6eeb;
		position: absolute;
		left: 50%;
		transform: translateX(-50%);
		border-radius: 15px;
	}

	.white-box {
		width: 90%;
		height: 80px;
		margin: 0px auto;
		position: absolute;
		left: 50%;
		top: 50%;
		transform: translate(-50%, -50%);
		background: linear-gradient(90deg, #fff, #c9bdf4);
		border-radius: 15px;
	}

	.now-coin-word {
		line-height: 20px;
		font-size: 20px;
		font-weight: bold;
		position: absolute;
		top: 30px;
		left: 15px;
	}

	.now-coin-img {
		width: 50px;
		height: 50px;
		position: absolute;
		right: 20px;
		top: 15px;
	}

	.balance-box {
		width: 85%;
		height: 180px;
		background-color: #404261;
		position: absolute;
		top: 230px;
		left: 50%;
		transform: translateX(-50%);
		border-radius: 15px;
	}
	
	.balance-box-title {
		color: white;
		margin: 10px;
		margin-left: 15px;
		font-weight: bold;
	}
	
	.balance-line {
		width: 90%;
		height: 100%;
		position: absolute;
		top: calc(50% - 10px);
		left: 50%;
		transform: translate(-50%, -50%);
	}

	.queations-box {
		width: 85%;
		height: 100px;
		background: linear-gradient(0deg, #3e3f63, #373758);
		position: absolute;
		top: 350px;
		left: 50%;
		transform: translateX(-50%);
		border-radius: 15px;
	}
</style>