<template>
	<view class="all">
		<view class="header">
			<view class="previous" @click="jumpBack">
				<img src="/static/previous_icon.png" alt="" class="previous-img" />
			</view>
			<view class="header-title">
				我的时间币
			</view>
		</view>
		<view class="subtitle">
			<view class="subtitle-content" @click="jumpToMyCoin">我的时间币</view>
			<view class="subtitle-content">历史记录</view>
			<view class="subtitle-content active">余额</view>
		</view>
		<view class="content" v-for="item in itemsAccepted" :key="item.id">
			<image :src="item.img" class="content-image"></image>
			<view class="content-middle">
				<view class="content-title">{{ item.title }}</view>
				<view class="content-time">{{ item.time }}</view>
			</view>
			<view class="content-balance" :style="{ color: item.balance > 0 ? '#e06c6b' : '#98c379' }">
				{{ item.balance > 0 ? '+' + item.balance : item.balance }} TB
			</view>
		</view>
		<!-- <view class="questions-box">
			<view class="questions-box-title">
				时间币不足？
			</view>
			<view class="question-list">
				<view class="question-item">
					<text class="question-answer">· 可通过完成特定任务获得</text>
				</view>
				<view class="question-item">
					<text class="question-answer">· 可以购买直接获得</text>
				</view>
				<view class="pay-button">
					充值入口
				</view>
			</view>
		</view> -->
	</view>
</template>

<script setup>
	import {
		ref
	} from 'vue';

	const jumpBack = () => {
		console.log("Jump back.")
		uni.switchTab({
			url: '/pages/userInfo/userInfo'
		});
	}

	const jumpToMyCoin = () => {
		console.log("Jump To My Coin.");
		uni.navigateTo({
			url: '/pages/myCoin/myCoin'
		})
	}

	const count = 500;

	const items = ref([{
			id: 1,
			title: 'PPT制作',
			time: '2025/4/17',
			status: '接收中',
			img: 'https://s21.ax1x.com/2025/03/02/pEGVjw4.jpg',
			balance: 50,
		},
		{
			id: 2,
			title: '技能',
			time: '2025/4/17',
			status: '已拒绝',
			img: 'https://s21.ax1x.com/2025/03/02/pEGVjw4.jpg',
			balance: 0,
		},
		{
			id: 3,
			title: '历史',
			time: '2025/4/17',
			status: '已接受',
			img: 'https://s21.ax1x.com/2025/03/02/pEGVjw4.jpg',
			balance: 50,
		}
	]);

	const itemsAccepted = items.value.filter(item => item.balance != 0);
</script>

<style>
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
		margin-top: 40px;
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
		margin-top: 40px;
	}

	.subtitle {
		width: 90%;
		display: flex;
		flex-direction: row;
		margin: 20px auto 0px;
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

	.content {
		width: 85%;
		margin: 20px auto;
		background-color: white;
		border-radius: 10px;
		flex: 1;
		overflow-y: auto;
	}

	.content-image {
		width: 60px;
		height: 60px;
		position: relative;
		float: left;
		margin: 10px;
		border-radius: 50%;
	}

	.content-middle {
		position: relative;
		float: left;
	}

	.content-title {
		font-weight: bold;
		line-height: 30px;
		margin-top: 15px;
	}

	.content-time {
		color: #5e5e5e;
		line-height: 20px;
	}

	.content-balance {
		position: relative;
		float: right;
		line-height: 80px;
		font-size: 30px;
		margin-right: 10px;
	}

	.questions-box-title {
		color: white;
		margin: 10px;
		margin-left: 15px;
		font-weight: bold;
	}

	.questions-box {
		width: 85%;
		height: 160px;
		background: linear-gradient(0deg, #3e3f63, #373758);
		position: absolute;
		margin-top: 440px;
		left: 50%;
		transform: translateX(-50%);
		border-radius: 15px;
	}

	.question-list {
		margin-left: 10px;
	}

	.question-title {
		font-size: 16px;
		color: white;
	}

	.question-answer {
		font-size: 14px;
		color: #ccc;
	}

	.pay-button {
		width: calc(100% - 30px);
		height: 30px;
		background: linear-gradient(90deg, #7ca9f5, #965fee);
		text-align: center;
		line-height: 30px;
		margin: 10px;
		margin-top: 20px;
		color: white;
		font-size: 16px;
		border-radius: 15px;
	}
</style>