<template>
	<view class="container">
		<view class="test-page-container" v-show="isSectionsMoving">
			<homePage @showTabBar="showTabBar"></homePage>
		</view>

		<view class="content">
			<view class="top-section" :class="{ 'move-up': isSectionsMoving }">
			</view>
			<view class="bottom-section" :class="{ 'move-down': isSectionsMoving }"></view>
			<view class="content-section" :class="{ 'move-down': isSectionsMoving }">
				<div class="logo"></div>
				<div class="app-name">{{ app_name }}</div>
				<div class="app-desc">{{ app_desc }}</div>
				<button class="enter-btn" @click="handleEnterClick">{{ enter_btn_text }}</button>
			</view>
		</view>
	</view>
</template>

<script setup>
	import {
		ref,
		onMounted,
		onUnmounted
	} from 'vue';
	import homePage from '../home/home.vue'; // 导入 home 页面组件

	const app_name = 'U Trade!';
	const app_desc = "大学生技能交换市场";
	const enter_btn_text = "进入";
	const isSectionsMoving = ref(false);
	
	const showTabBar = () => {
		console.log("Show Tab Bar.")
	}

	const handleEnterClick = () => {
		isSectionsMoving.value = true;
		setTimeout(onTransitionEnd, 750);
	};

	const onTransitionEnd = () => {
		uni.switchTab({
			url: '/pages/home/home'
		});
	};
</script>

<style scoped>
	.container {
		position: relative;
		height: 100vh;
		width: 100%;
	}

	.test-page-container {
		position: fixed;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		z-index: 1;
	}

	.content {
		position: fixed;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		z-index: 2;
	}

	.top-section {
		height: 50%;
		background: linear-gradient(180deg, #47acf0 100%, #2196f3 100%);
		-webkit-mask-image: linear-gradient(to bottom,
				rgba(0, 0, 0, 1) 0%,
				rgba(0, 0, 0, 1) 60%,
				rgba(0, 0, 0, 0) 100%);
		mask-image: linear-gradient(to bottom,
				rgba(0, 0, 0, 1) 0%,
				rgba(0, 0, 0, 1) 60%,
				rgba(0, 0, 0, 0) 100%);
		transition: transform 1.2s ease-out;
	}

	.move-up {
		transform: translateY(-100%);
	}

	.bottom-section {
		height: 70%;
		background-color: white;
		clip-path: ellipse(131% 100% at 50% 100%);
		transform: translateY(-20%);
		transition: transform 1.2s ease-out;
	}

	.move-down {
		transform: translateY(100%);
	}

	.logo {
		width: 30%;
		aspect-ratio: 1/1;
		background-color: white;
		background-image: url('/static/U_logo.png');
		background-repeat: no-repeat;
		background-position: center;
		position: absolute;
		left: 50%;
		top: 39%;
		transform: translate(-50%, -50%);
		border-radius: 50rpx;
		box-shadow: 5rpx 8rpx 10rpx rgba(22, 22, 22, 0.1);
	}

	.content-section {
		position: absolute;
		top: 45%;
		left: 50%;
		transform: translate(-50%, -50%);
		display: flex;
		flex-direction: column;
		align-items: center;
		width: 100%;
		transition: transform 1.4s ease-out;
	}

	.content-section.move-down {
		transform: translate(-50%, 100%);
	}

	.fade-out {
		opacity: 0;
		pointer-events: none;
	}

	.app-name {
		font-size: 75rpx;
		color: #333333;
		font-weight: bold;
		padding-top: 90%;
	}

	.app-desc {
		font-size: 32rpx;
		color: #949494;
		padding-top: 30rpx;
		padding-bottom: 50%;
	}

	.enter-btn {
		width: 40vw;
		height: 6vh;
		line-height: 6vh;
		border-radius: 60rpx;
		background: linear-gradient(90deg, #45aefd 0%, #5160ff 100%);
		color: #eeeeee;
		font-size: 36rpx;
		font-weight: 600;
		text-align: center;
		box-shadow: 0 4rpx 16rpx rgba(33, 150, 243, 0.3);
	}

	.enter-btn:active {
		transform: scale(0.98);
		box-shadow: 0 2rpx 8rpx rgba(33, 150, 243, 0.3);
	}
</style>