<template>
	<view class="all">
		<view class="circle-section"></view>
		<view class="title">
			<view class="app-icon"></view>
			<view class="app-text">{{ app_name }}</view>
			<view class="right">
				<view class="search_icon"></view>
			</view>
		</view>

		<view class="user-info">
			<view class="avatar">
				<image src="/static/user_avatar.png" alt=""></image>
			</view>
			<view class="info">
				<text class="nickname">薛皓</text>
				<text class="status">我的发布</text>
			</view>
			<view class="actions">
				<button class="action-button">财务健康</button>
				<button class="action-button">授权</button>
				<button class="action-button">退出登录</button>
			</view>
		</view>

		<view class="nav">
			<view class="nav-item">
				<img src="/static/money_icon.png" alt="" class="nav-icon" />
				时间币
			</view>
			<view class="nav-item">
				<img src="/static/release_icon.png" alt="" class="nav-icon" />
				我的发布
			</view>
			<view class="nav-item">
				<img src="/static/setting_icon.png" alt="" class="nav-icon" />
				设置
			</view>
			<view class="nav-item">
				<img src="/static/user_icon.png" alt="" class="nav-icon" />
				退出登录
			</view>
		</view>

		<view class="card-skills">
			<view class="card-before">
				<view class="card-before-left">
					我的
				</view>
				<view class="card-before-right">
					查看详情 >
				</view>
			</view>
			<view class="card-item">
				<img src="/static/task_icon.png" alt="release" class="card-img" />
				<text class="card-title">我的发布</text>
				<text class="card-subtitle">搜索系统</text>
			</view>
			<view class="card-item">
				<img src="/static/transaction_icon.png" alt="transaction" class="card-img" />
				<text class="card-title">我的交换记录</text>
				<text class="card-subtitle">76250条</text>
			</view>
			<view class="card-item">
				<img src="/static/coin_icon.png" alt="balance" class="card-img" />
				<text class="card-title">时间币余额</text>
				<text class="card-subtitle">202个</text>
			</view>
			<view class="card-item">
				（待做）balance-line
			</view>
		</view>
	</view>
</template>

<script setup>
	const app_name = 'UTrade!';
</script>

<style scoped>
	.all {
		background-color: #f4f4f4;
	}

	.title {
		width: 100%;
		display: flex;
		align-items: center;
		justify-content: flex-start;
		position: absolute;
		z-index: 1;
	}

	.app-icon {
		width: 30px;
		height: 30px;
		margin: 30px 20px;
		background-image: url('/static/U_icon.png');
		background-repeat: no-repeat;
		background-size: contain;
		border-radius: 50%;
		margin-right: 10px;
		border: 2px, #fff, solid;
	}

	.app-text {
		width: 25%;
		font-size: 16px;
		color: #fff;
		font-weight: bold;
	}

	.right {
		position: absolute;
		right: 0;
	}

	.search_icon {
		width: 25px;
		height: 25px;
		margin: 30px 20px;
		background-image: url('/static/search_icon.png');
		background-repeat: no-repeat;
		background-size: contain;
		border-radius: 50%;
		float: right;
	}

	.circle-section {
		position: absolute;
		left: 50%;
		top: 0%;
		transform: translate(-50%, -50%);
		width: 200%;
		height: 100%;
		background-color: #7074f9;
		z-index: 0;
		border-radius: 100%;
	}


	.user-info {
		display: flex;
		flex-direction: column;
		align-items: center;
		margin: 20px 0;
	}

	.avatar {
		margin-top: 100px;
		background-color: pink;
		width: 80px;
		height: 80px;
		border-radius: 50%;
		overflow: hidden;
	}

	.avatar image {
		width: 100%;
		height: 100%;
	}

	.info {
		display: flex;
		flex-direction: column;
		align-items: center;
	}

	.nickname {
		font-size: 18px;
		color: #fff;
		font-weight: bold;
		margin-top: 10px;
		z-index: 1;
	}

	.status {
		font-size: 14px;
		color: #ccc;
		z-index: 1;
	}

	.actions {
		width: 90%;
		padding: 8px;
		display: flex;
		margin-top: 10px;
	}

	.action-button {
		flex: 1;
		height: 40px;
		margin: 0 5px;
		background-color: #9095fb;
		color: #fff;
		font-size: 12px;
		text-align: center;
		line-height: 40px;
		border-radius: 25px;
	}

	.nav {
		display: flex;
		position: absolute;
		z-index: 1;
		height: 80px;
		width: 86%;
		margin: 0 7%;
		background-color: #fff;
		justify-content: center;
		align-items: center;
		border-radius: 25px;
	}

	.nav-item {
		width: 23%;
		height: 80%;
		/* background-color: pink; */
		text-align: center;
		align-content: center;
		justify-content: center; /* 垂直居中 */
		align-items: center;
		border-radius: 25px;
		font-size: 10px;
		display: flex;
		flex-direction: column;
		padding: 10px 0;
	}

	.nav-icon {
		margin: 0% auto 5%;
		width: 40%;
		max-width: 40px;
	}

	.card-skills {
		position: relative;
		margin: 110px 0;
	}
	
	/* .card-before {
		margin: 25px 15px 10px;
		font-size: 18px;
	} */
	
	.card-before-left {
		margin: 5px 15px 10px;
		font-size: 18px;
		float: left;
		font-weight: bold;
	}
	
	.card-before-right {
		margin: 5px 20px 10px;
		font-size: 16px;
		color: #888;
		float: right;
		font-weight: bold;
	}

	.card-item {
		width: 80%;
		height: 25px;
		margin: 0 auto;
		text-align: center;
		align-content: center;
		background-color: white;
		margin-bottom: 10px;
		padding: 15px;
		border-radius: 20px;
		box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	}
	
	.card-img {
		height: 90%;
		margin: auto 0;
		margin-right: 10px;
		float: left;
	}

	.card-title {
		font-size: 16px;
		font-weight: bold;
		float: left;
	}

	.card-subtitle {
		font-size: 14px;
		color: #888;
		float: right;
	}

	.footer-nav {
		display: flex;
		justify-content: space-around;
		background-color: #f8f8f8;
		padding: 10px 0;
	}

	.footer-item {
		flex: 1;
		text-align: center;
		font-size: 14px;
	}
</style>