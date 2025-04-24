<script setup>
import { ref,onMounted } from 'vue';

const skillInfo = ref({
    image: '',
    title: '',
    avatar: '',
    username: ''
});

onMounted(() => {
    try {
        const data = uni.getStorageSync('currentSkillInfo');
        if (data) {
            console.log('从存储中获取的数据:', data);
            skillInfo.value = data;
        } else {
            console.log('没有找到存储的技能数据');
        }
    } catch (e) {
        console.error('获取存储数据时出错:', e);
    }
});

const handleExchange = () => {
    // 显示提示框
    uni.showToast({
        title: '已发起交换',
        icon: 'success',
        duration: 1500
    });
    
    // 1.5秒后返回首页
    setTimeout(() => {
        uni.switchTab({
            url: '/pages/home/home'
        });
    }, 1000);
};
const handleBack = () => {
        uni.switchTab({
            url: '/pages/home/home'
        });
};
</script>

<template>
    <view class="total">
        <!-- 返回按钮和标题 -->
        <view class="back">
            <img class="back-icon" @click="handleBack" width="40" height="40" 
                src="https://img.icons8.com/badges/48/left.png" alt="left" />
            <text class="title">技能详情</text>
        </view>

        <!-- 用户信息 -->
        <view class="info">
            <view class="user-profile">
                <image class="avatar" :src="skillInfo.avatar || '/static/default-avatar.png'" mode="aspectFill" />
                <view class="user-info">
                    <text class="certification">已认证</text>
                    <text class="username">{{ skillInfo.username || '加载中...' }}</text>
                </view>
            </view>
        </view>

        <!-- 技能详情 -->
        <view class="skill-details">
            <view class="section">
                <text class="label">技能</text>
                <view class="skill-tag">{{ skillInfo.title || '加载中...' }}</view>
            </view>

            <view class="section">
                <text class="label">想交换</text>
                <view class="skill-tag">乒乓球</view>
            </view>

            <view class="section">
                <text class="label">示例图</text>
                <image 
                    :src="skillInfo.image || '/static/default-image.png'" 
                    mode="aspectFill" 
                    class="example-image"
                />
            </view>

            <button class="exchange-btn" @click="handleExchange">发起交换</button>
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
  