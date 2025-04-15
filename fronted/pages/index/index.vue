<template>
    <view class="content">
        <view class="top-section">
        </view>
		<view class="circle-section1"></view>
		<view class="circle-section2"></view>
        <view class="content-section">
			<div class="logo"></div>
            <div class="app-name">{{app_name}}</div>
            <div class="app-desc">{{app_desc}}</div>
            <button class="enter-btn">{{enter_btn_text}}</button>
        </view>
    </view>
</template>

<script setup>
const app_name='U Trade!';
const app_desc="大学生技能交换市场";
const enter_btn_text="进入";
</script>

<style>
 .content {
        height: 100vh;
        position: relative;
        background-color: #ffffff;
        width: 100%; 
        overflow: hidden;
    }

	.top-section {
        height: 50%;
        background: linear-gradient(180deg, #47acf0 0%, #2196f3 100%);
        position: relative;
    }
.circle-section1,
.circle-section1 {
	position: absolute;
	left: 50%;
    top: 76%;
    transform: translate(-50%, -50%);
	width: 200%;
	height: 80%;
	background-color: white;
	z-index: 0;
	border-radius: 100%;
}
	.logo{
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
		box-shadow:  5rpx 8rpx 10rpx rgba(22, 22, 22, 0.1);
	}

    .wave {
        position: absolute;
        bottom: -2px;
        left: 0;
        width: 100%;
        line-height: 0;
    }

    .wave svg {
        position: relative;
        display: block;
        width: 100%;
        height: 100px;
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
		padding-top:30rpx;
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