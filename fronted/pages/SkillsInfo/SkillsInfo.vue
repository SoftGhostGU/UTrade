<script setup>
import { ref } from 'vue';

const skillInfo = ref({
    image: '',
    title: '',
    avatar: '',
    username: ''
});

const handleBack = () => {
    uni.navigateBack({
        delta: 1
    });
};
function onLoad(option) {
    // 获取页面通道
    const eventChannel = this.getOpenerEventChannel();
    // 添加错误处理
    try {
        eventChannel.on('acceptSkillData', (data) => {
            console.log('SkillsInfo 接收到数据:', data);
            // 确保数据更新是响应式的
            skillInfo.value = {
                image: data.image,
                title: data.title,
                avatar: data.avatar,
                username: data.username
            };
            console.log('更新后的 skillInfo:', skillInfo.value);
        });
    } catch (error) {
        console.error('数据接收错误:', error);
    }
}
defineExpose({
    onLoad
});
</script>

<template>
    <view class="total">
        <view class="back">
            <img class="back-icon" @click="handleBack" width="40" height="40" 
                src="https://img.icons8.com/badges/48/left.png" alt="left" />
            <text class="title">技能详情</text>
        </view>

        <view class="info">
            <view class="user-profile">
                <image class="avatar" :src="skillInfo.avatar" mode="aspectFill" />
                <view class="user-info">
                    <text class="certification">已认证</text>
                    <text class="username">{{skillInfo.username}}</text>
                </view>
            </view>
        </view>

        <view class="skill-details">
            <view class="section">
                <text class="label">技能</text>
                <view class="skill-tag">{{skillInfo.title}}</view>
            </view>

            <view class="section">
                <text class="label">想交换</text>
                <view class="skill-tag">乒乓球</view>
            </view>

            <view class="section">
                <text class="label">示例图</text>
                <image 
                    :src="skillInfo.image" 
                    mode="aspectFill" 
                    class="example-image"
                />
            </view>

            <button class="exchange-btn">发起交换</button>
        </view>
    </view>
</template>
  
<style scoped>
.total {
    width: 100vw;
    height: 100vh;
    background: linear-gradient(to bottom, #a160f6, #420df3);
    display: flex;
    flex-direction: column;
    position: relative;
}

.back {
    width: 100%;
    height: 3rem;
    margin-top: 2rem;
    display: flex;
    align-items: center;
    position: relative;
}

.back-icon {
    position: absolute;
    left: 1rem;
    z-index: 9;
}

.title {
    width: 100%;
    text-align: center;
    color: white;
    font-size: 1.2rem;
    font-weight: bold;
}

.info {
    width: 100%;
    height: 5rem;
    padding: 0 1.5rem;
    display: flex;
    align-items: center;
}

.user-profile {
    display: flex;
    align-items: center;
}

.avatar {
    width: 3.5rem;
    height: 3.5rem;
    border-radius: 50%;
    border: 2px solid white;
}

.user-info {
    margin-left: 1rem;
    display: flex;
    flex-direction: column;
    gap: 0.5rem;
}

.certification {
    font-size: 1.2rem;
    color: #fcf8ff;
    font-weight: 700;
}

.username {
    font-size: 1rem;
    color: rgb(130, 130, 130);
}

.skill-details {
    width: 100%;
    height: calc(100vh - 10rem);
    background-color: #fefefc;
    border-radius: 1.5rem 1.5rem 0 0;
    padding: 2rem 1.5rem;
    box-sizing: border-box;
    position: absolute;
    bottom: 0;
    z-index: 1;
}

.section {
    margin-bottom: 2rem;
}

.label {
    font-size: 1rem;
    font-weight: 600;
    margin-bottom: 1rem;
    display: block;
    color: #333;
}

.skill-tag {
    background-color: #f5f5f6;
    padding: 0.8rem 1.2rem;
    border-radius: 1rem;
    display: inline-block;
    color: #666;
    font-size: 1rem;
    width: 80%;
}

.example-image {
    width: 100%;
    height: 200px;
    border-radius: 1rem;
    object-fit: cover;
}

.exchange-btn {
    width: 60%;
    height: 3rem;
    background: linear-gradient(to right, #8a8ce7, #de80f3);
    color: white;
    border: none;
    border-radius: 1.5rem;
    font-size: 1.1rem;
    font-weight: bold;
    position: fixed;
    bottom: 2rem;
    left: 50%;
    transform: translateX(-50%);
    display: flex;
    align-items: center;
    justify-content: center;
}

.exchange-btn:active {
    opacity: 0.9;
}
</style>
  