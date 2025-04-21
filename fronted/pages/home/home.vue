<script setup>
	import { ref } from 'vue';
import { useSkillStore } from '@/store/skillStore' 
import { storeToRefs } from 'pinia'
const searchText = ref('');
const skillStore = useSkillStore()
const { skills } = storeToRefs(skillStore)

	// 根据 label 设置背景色
	const getLabelBackgroundColor = (label) => {
    switch (label) {
        case '热门':
            return '#efc958';
        case '直播中':
            return '#f46d60';
        case '推荐':
            return '#4ac58e';
        default:
            return '#ccc';
    }
};

	const MessageNavigate = () => {
		uni.navigateTo({
			url: '/pages/message/message',
		});
	};
	
	const jumpToChat = () => {
		console.log("Jump To Chat.");
		uni.navigateTo({
			url: '/pages/chat/chat'
		});
	};
</script>

<template>
	<view class="home">
		<!-- 头部导航栏 -->
		<header>
			<div class="header-content">
				<div class="logo">
					<strong style="color: white;" class="Ulogo">U</strong>
					<strong style="color: white;">Trade</strong>
					————大学生技能交换市场
				</div>
			</div>
			<div class="bell" @click="MessageNavigate">
				<svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" width="25" height="25" viewBox="0,0,256,256">
					<g fill="#ffffff" fill-rule="nonzero" stroke="none" stroke-width="1" stroke-linecap="butt"
						stroke-linejoin="miter" stroke-miterlimit="10" stroke-dasharray="" stroke-dashoffset="0"
						font-family="none" font-weight="none" font-size="none" text-anchor="none"
						style="mix-blend-mode: normal">
						<g transform="scale(5.12,5.12)">
							<path
								d="M25,0c-2.19922,0 -4,1.80078 -4,4c0,0.51563 0.10156,1.01563 0.28125,1.46875c-5.625,1.46094 -9.28125,6.34766 -9.28125,12.53125c0,7.83203 -1.92187,11.39844 -3.75,13.40625c-0.91406,1.00391 -1.81641,1.61328 -2.59375,2.1875c-0.39062,0.28516 -0.74609,0.57031 -1.0625,0.9375c-0.31641,0.36719 -0.59375,0.89063 -0.59375,1.46875c0,1.375 0.84375,2.54297 2.03125,3.3125c1.1875,0.76953 2.74609,1.26563 4.625,1.65625c2.4375,0.50391 5.44531,0.76953 8.75,0.90625c-0.25,0.66406 -0.40625,1.37891 -0.40625,2.125c0,3.30078 2.69922,6 6,6c3.30078,0 6,-2.69922 6,-6c0,-0.75 -0.15234,-1.46484 -0.40625,-2.125c3.30469,-0.13672 6.3125,-0.40234 8.75,-0.90625c1.87891,-0.39062 3.4375,-0.88672 4.625,-1.65625c1.1875,-0.76953 2.03125,-1.9375 2.03125,-3.3125c0,-0.57812 -0.27734,-1.10156 -0.59375,-1.46875c-0.31641,-0.36719 -0.67187,-0.65234 -1.0625,-0.9375c-0.77734,-0.57422 -1.67969,-1.18359 -2.59375,-2.1875c-1.82812,-2.00781 -3.75,-5.57422 -3.75,-13.40625c0,-6.17969 -3.66406,-11.0625 -9.28125,-12.53125c0.17969,-0.45312 0.28125,-0.95312 0.28125,-1.46875c0,-2.19922 -1.80078,-4 -4,-4zM25,2c1.11719,0 2,0.88281 2,2c0,1.11719 -0.88281,2 -2,2c-1.11719,0 -2,-0.88281 -2,-2c0,-1.11719 0.88281,-2 2,-2zM27.34375,7.1875c5.33203,0.94922 8.65625,5.07031 8.65625,10.8125c0,8.16797 2.07813,12.36328 4.25,14.75c1.08594,1.19141 2.18359,1.9375 2.90625,2.46875c0.35938,0.26563 0.62891,0.48828 0.75,0.625c0.12109,0.13672 0.09375,0.125 0.09375,0.15625c0,0.625 -0.28906,1.08203 -1.125,1.625c-0.83594,0.54297 -2.19531,1.04688 -3.9375,1.40625c-3.48437,0.72266 -8.44531,0.96875 -13.9375,0.96875c-5.49219,0 -10.45312,-0.24609 -13.9375,-0.96875c-1.74219,-0.35937 -3.10156,-0.86328 -3.9375,-1.40625c-0.83594,-0.54297 -1.125,-1 -1.125,-1.625c0,-0.03125 -0.02734,-0.01953 0.09375,-0.15625c0.12109,-0.13672 0.39063,-0.35937 0.75,-0.625c0.72266,-0.53125 1.82031,-1.27734 2.90625,-2.46875c2.17188,-2.38672 4.25,-6.58203 4.25,-14.75c0,-5.73828 3.32813,-9.82812 8.65625,-10.78125c0.66406,0.48828 1.46484,0.78125 2.34375,0.78125c0.88672,0 1.67969,-0.31641 2.34375,-0.8125zM21.5625,41.9375c1.12109,0.02344 2.26172,0.0625 3.4375,0.0625c1.17578,0 2.31641,-0.03906 3.4375,-0.0625c0.35547,0.60156 0.5625,1.3125 0.5625,2.0625c0,2.22266 -1.77734,4 -4,4c-2.22266,0 -4,-1.77734 -4,-4c0,-0.75781 0.19922,-1.46094 0.5625,-2.0625z">
							</path>
						</g>
					</g>
				</svg>
			</div>
			<view class="search-bar">
				<view class="search-icon">
					<svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" width="20" height="20" viewBox="0 0 30 30">
						<path
							d="M 13 3 C 7.4889971 3 3 7.4889971 3 13 C 3 18.511003 7.4889971 23 13 23 C 15.396508 23 17.597385 22.148986 19.322266 20.736328 L 25.292969 26.707031 A 1.0001 1.0001 0 1 0 26.707031 25.292969 L 20.736328 19.322266 C 22.148986 17.597385 23 15.396508 23 13 C 23 7.4889971 18.511003 3 13 3 z M 13 5 C 17.430123 5 21 8.5698774 21 13 C 21 17.430123 17.430123 21 13 21 C 8.5698774 21 5 17.430123 5 13 C 5 8.5698774 8.5698774 5 13 5 z">
						</path>
					</svg>
				</view>
				<input type="text" v-model="searchText" placeholder="技能发布"
					style="flex: 1; border: none; outline: none; font-size: 16px; color: black;">
			</view>
			<text class="header-left">技能发布</text>
		</header>

		<!-- 页面主体 -->
		<view class="main">
			<h3>热门技能</h3>

			<!-- 热门技能展示 -->
			<view class="skill-cards">
    <view v-for="(skill, index) in skills" :key="index" class="card">
        <view class="card-cover">
            <image :src="skill.cover" mode="aspectFill" style="width: 100%; height: 200px;"></image>
            <view class="card-label" :style="{ backgroundColor: getLabelBackgroundColor(skill.label) }">
                {{ skill.label }}
            </view>
        </view>
        <h4>{{ skill.title }}</h4>
        <view class="profile">
            <view class="avatar">
                <img :src="skill.avater" style="width: 100%; height: 100%; border-radius: 50%;">
            </view>
            <span>{{ skill.username }}</span>
        </view>
    </view>
</view>
		</view>
		<view class="chat" @click="jumpToChat">
			<img src="/static/chat_icon.png" alt="chat" class="chat-img" />
		</view>
	</view>
</template>



<style>
	/* 全局样式 */
	.home {
		max-width: 600px;
		margin: 0 auto;
		min-height: 100vh;
		background-color: #f5f5f5;
	}

	/* 头部样式 */
	header {
		background: linear-gradient(to bottom, #855aec, #63a6f6);
		height: 200px;
		clip-path: ellipse(100% 100% at 50% 0%);
		padding: 10px 20px;
		display: flex;
		flex-direction: column;
		justify-content: space-around;
		align-items: center;
		color: white;
	}

	.header-content {
		display: flex;
		justify-content: space-between;
	}

	.bell {
		position: absolute;
		top: 0.6rem;
		right: 0.6rem;
	}

	.header-left {
		color: white;
		font-size: 1.2rem;
		align-self: flex-start;
		font-family: '华文琥珀';
		margin: 0 0 1rem 1.5rem;
		position: relative;
	}

	.header-left::after {
		content: '';
		position: absolute;
		left: 50%;
		transform: translate(-50%, -50%);
		bottom: -0.6rem;
		width: 60%;
		height: 0.25rem;
		background-color: #ecc483;
		border-radius: 2px;
	}

	.logo {
		font-size: 32rpx;
		font-weight: 500;
		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	}

	.logo strong {
		font-size: 60rpx;
		font-weight: 1000;
	}

	.logo .Ulogo {
		font-size: 80rpx;
		font-weight: 1000;
		font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	}

	/* 搜索栏样式 */
	.search-bar {
		width: 80vw;
		background-color: #fff;
		padding: 10px 10px;
		border-radius: 19px;
		display: flex;
		align-items: center;
	}

	.search-icon {
		width: 30px;
		display: flex;
		align-items: center;
		margin-right: 10px;
	}

	h3 {
		margin-bottom: 1rem;
	}

	/* 页面主体样式 */
	.main {
		padding: 20px;
	}

	.skill-cards {
		display: grid;
		grid-template-columns: repeat(2, 1fr);
		gap: 20px;
	}

	.card {
		border-radius: 10px;
		box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	}

	.card-cover {
		position: relative;
		overflow: hidden;
		aspect-ratio: 1/1;
		background-color: #7e67f4;
		border-radius: 1rem;
	}

	.card-label {
		position: absolute;
		top: 10px;
		left: 10px;
		color: white;
		padding: 5px 10px;
		border-radius: 5px;
		font-size: 12px;
	}

	.card-badge {
		position: absolute;
		bottom: 10px;
		right: 10px;
		color: #6a59ca;
		font-size: 16px;
	}

	.card h4 {
		padding: 10px;
		font-size: 16px;
		color: #333;
	}

	.profile {
		padding: 10px;
		display: flex;
		align-items: center;
	}

	.profile span {
		font-size: 0.8rem;
	}

	.avatar {
		width: 30px;
		height: 30px;
		border-radius: 50%;
		background-color: #ccc;
		overflow: hidden;
		/* 确保图像内容不会超出圆形 */
		margin-right: 10px;
	}

	.avatar img {
		width: 100%;
		height: 100%;
		border-radius: 50%;
		object-fit: cover;
		/* 确保图像内容覆盖整个圆形 */
	}
	
	.chat {
		width: 50px;
		height: 50px;
		margin: 10px;
		position: fixed;
		right: 0px;
		bottom: 50px;
		z-index: 100;
		background-color: #558ae0;
		border-radius: 25px;
	}
	
	.chat-img {
		width: 60%;
		height: 60%;
		margin: 20% 20%;
	}
</style>