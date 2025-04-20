<template>
	<view class="all">
		<view class="header">
			<view class="previous" @click="jumpBack">
				<img src="/static/previous_icon.png" alt="" class="previous-img" />
			</view>
			<view class="header-title">
				互换管理
			</view>
		</view>
		<view class="body">
			<view class="tabs">
				<button class="tab-button active">全部</button>
				<button class="tab-button">已接受</button>
				<button class="tab-button">已拒绝</button>
				<button class="tab-button">接收中</button>
			</view>
			<view class="content" v-for="item in items" :key="item.id">
				<view class="card">
					<view class="user-image">
						<img :src="item.img" alt="" class="user-image" />
					</view>
					<view class="card-header">
						<view class="card-title">{{ item.title }}</view>
						<view class="card-body">
							<view>{{ item.time }}</view>
						</view>
					</view>
					<view class="card-status">{{ item.status }}</view>
				</view>
			</view>
		</view>
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

	const items = ref([{
			id: 1,
			title: 'PPT制作',
			time: '2025/4/17',
			status: '接收中',
			img: 'https://s21.ax1x.com/2025/03/02/pEGVjw4.jpg'
		},
		{
			id: 2,
			title: '技能',
			time: '2025/4/17',
			status: '已拒绝',
			img: 'https://s21.ax1x.com/2025/03/02/pEGVjw4.jpg'
		},
		{
			id: 3,
			title: '历史',
			time: '2025/4/17',
			status: '已接受',
			img: 'https://s21.ax1x.com/2025/03/02/pEGVjw4.jpg'
		}
	]);
</script>

<style scoped>
	.all {
		height: 100vh;
		display: flex;
		flex-direction: column;
		background-color: #7774f2;
	}

	.header {
		flex: 1;
		display: flex;
		flex-direction: row;
	}

	.previous {
		display: block;
		width: 30px;
		height: 30px;
		margin-top: 30px;
		margin-left: 15px;
		margin-bottom: 15px;
		line-height: 30px;
		font-size: 28px;
		text-align: center;
		align-content: center;
		color: white;
		font: bold;
	}

	.previous-img {
		width: 30px;
		height: 30px;
	}

	.header-title {
		width: calc(100% - 90px);
		color: white;
		font: bold;
		font-size: 18px;
		text-align: center;
		align-content: center;
		line-height: 30px;
		margin-top: 20px;
	}

	.body {
		width: 100%;
		height: 90%;
		background: linear-gradient(to bottom, #a5cbf5, #8daef2);
		border-radius: 30px 30px 0px 0px;
		padding: 20px;
		box-sizing: border-box;
	}

	.tabs {
		display: flex;
		justify-content: space-around;
		margin-bottom: 20px;
	}

	.tab-button {
		width: calc(25% - 5px);
		height: 30px;
		line-height: 30px;
		font-size: 12px;
		border-radius: 15px;
		background-color: #cfd4e6;
		color: white;
		cursor: pointer;
	}

	.tab-button.active {
		background-color: #7b75eb;
	}

	.content {
		background-color: white;
		margin-bottom: 10px;
		border-radius: 10px;
		padding: 10px;
		flex: 1;
		overflow-y: auto;
	}

	.card {
		display: flex;
		flex-direction: row;
		padding: 10px;
		border-radius: 10px;
		background-color: #f7f7f7;
		color: black;
	}

	.card-header {
		display: flex;
		width: calc(80% - 60px);
		flex-direction: column;
		align-items: left;
	}

	.user-image {
		width: 50px;
		height: 50px;
		border-radius: 50%;
		background-color: #ccc;
		margin-right: 10px;
	}

	.card-title {
		font-size: 16px;
		font-weight: bold;
	}

	.card-status {
		font-size: 14px;
		width: 20%;
		height: 18px;
		margin: auto 0;
		background-color: #7b75eb;
		color: white;
		padding: 5px 10px;
		border-radius: 15px;
		display: flex;
		align-items: center;
		justify-content: center;
	}

	.card-body {
		color: #ccc;
	}

	.next-button {
		display: block;
		width: 50px;
		height: 50px;
		margin: 20px auto 0;
		background-color: white;
		border: none;
		border-radius: 50%;
		cursor: pointer;
	}
</style>