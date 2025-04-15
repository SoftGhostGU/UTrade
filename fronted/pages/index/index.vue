<template>
    <view class="content">
        <view class="top-section">
        </view>
		
        <view class="content-section">
            <div class="app-name">U Trade!</div>
            <div class="app-desc">大学生技能交换市场</div>
            <button class="enter-btn">进入</button>
        </view>
    </view>
</template>

<script>
    export default {
        data() {
            return {
                title: 'U Trade!'
            }
        },
        onLoad() {
        },
        methods: {
        }
    }
</script>

<style>
    .content {
        height: 100vh;
        position: relative;
        background-color: #ffffff;
    }

    .top-section {
        height: 40%;
        background: linear-gradient(180deg, #47acf0 0%, #2196f3 100%);
        position: relative;
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
    top: 45%; /* 将 50% 改小一些 */
    left: 50%;
    transform: translate(-50%, -50%);
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 100%;
}

    .logo {
        width: 160rpx;
        height: 160rpx;
        margin-bottom: 30rpx;
    }

    .app-name {
        font-size: 48rpx;
        color: #333333;
        font-weight: bold;
		padding-top: 350px;
		box-sizing: content-box;
    }

    .app-desc {
        font-size: 32rpx;
        color: #666666;
        padding-bottom: 250px;
		box-sizing:content-box;
    }

    .enter-btn {
        width: 280rpx;
        height: 80rpx;
        line-height: 80rpx;
        border-radius: 40rpx;
        background: linear-gradient(90deg, #47acf0 0%, #2196f3 100%);
        color: #ffffff;
        font-size: 32rpx;
        text-align: center;
        box-shadow: 0 4rpx 16rpx rgba(33, 150, 243, 0.3);
    }

    .enter-btn:active {
        transform: scale(0.98);
        box-shadow: 0 2rpx 8rpx rgba(33, 150, 243, 0.3);
    }
</style>