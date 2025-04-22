<template>
	<view>
		<view class="previous" @click="JumpBack">
			<img src="/static/previous_icon_blue.png" alt="previous" class="previous-img" />
		</view>
		<div>
			<Chat :chats="chats" :onChatsChange="handleChatsChange" :onMessageSend="handleMessageSend"
				:uploadProps="uploadProps" :roleConfig="roleConfig" />
		</div>
	</view>
</template>

<script>
	// import {
	// 	ref,
	// 	nextTick
	// } from 'vue';
	// import {
	// 	Chat
	// } from '@kousum/semi-ui-vue';
	import {
		Chat,
		Radio,
		RadioGroup
	} from "@kousum/semi-ui-vue";
	import {
		defineComponent,
		ref
	} from "vue";
	import "@kousum/semi-ui-vue/dist/_base/base.css";
	import axios from "axios";
	export default {
		components: {
			Chat,
		},
		methods: {
			JumpBack() {
				console.log("Jump Back.");
				uni.switchTab({
					url: "/pages/home/home",
				});
			},
		},
		setup() {
			const chats = ref([{
					id: 1,
					role: "user",
					content: "Hello, how are you?",
					createAt: Date.now(),
				},
				{
					id: 2,
					role: "assistant",
					content: "I am good, thank you!",
					createAt: Date.now(),
				},
			]);

			// 设置用户和 AI 的头像
			const roleConfig = {
				user: {
					name: "User", // 用户名称
					avatar: "https://s21.ax1x.com/2025/03/02/pEGVjw4.jpg", // 用户头像的 URL
					color: "blue",
				},
				assistant: {
					name: "UTrade AI", // AI 名称
					avatar: "/static/U_AIChat_ava.png", // AI 头像的 URL
				},
			};

			const uploadProps = {
				// 配置上传参数
			};

			const handleChatsChange = (newChats) => {
				chats.value = newChats;
			};

			const handleMessageSend = async (content, attachments) => {
				const newChat = {
					id: chats.value.length,
					role: "user",
					content,
					attachments,
					createAt: Date.now(),
				};
				console.log("newChat: ", newChat);

				// 模拟 AI 回复
				// await nextTick(); // 确保用户消息已经渲染到 DOM

				// 添加一个 loading 状态的 AI 回复
				const aiChatLoading = {
					id: chats.value.length + 1,
					role: "assistant",
					content: "",
					status: "loading", // 设置为 loading 状态
					createAt: Date.now(),
				};
				chats.value.push(aiChatLoading);

				// 模拟 AI 生成回复的延迟
				await new Promise((resolve) => setTimeout(resolve, 2000)); // 延迟 2 秒

				let aiResponse = "默认回复";
				try {
					// 发送 POST 请求到后端的 /ner_ZH 路由
					const response = await axios.post("http://localhost:8080/ner_ZH", {
						text: content,
					});
					console.log("AI response: ", response.data);

					// 处理返回的实体数据
					const arg1Results = response.data.filter(result => result[1] === 'ARG1');
					if (arg1Results.length > 0) {
						aiResponse = "我注意到你提到了以下关键字：" + arg1Results.map(result => result[0]).join(", ");
					} else {
						aiResponse = generateAIResponse(content);
					}
				} catch (error) {
					console.log("error:", error);
					aiResponse = "抱歉，请求失败。";
				}

				// 更新 AI 回复的内容和状态
				const aiChatComplete = {
					...aiChatLoading,
					content: aiResponse,
					status: "complete",
				};

				// 替换 loading 状态的 AI 回复
				const index = chats.value.findIndex(
					(chat) => chat.id === aiChatLoading.id
				);
				if (index !== -1) {
					chats.value.splice(index, 1, aiChatComplete);
				}
				console.log("AIChat: ", aiResponse);
			};

			// 模拟 AI 回复逻辑
			const generateAIResponse = (userMessage) => {
				// 这里可以根据用户消息生成不同的回复
				if (userMessage.toLowerCase().includes("hello")) {
					return "Hi there! How can I help you today?";
				} else if (userMessage.toLowerCase().includes("how are you")) {
					return "I am just a program, but I am functioning well. Thank you for asking!";
				} else {
					return "I am not sure how to respond to that. Can you please clarify?";
				}
			};

			return {
				chats,
				handleChatsChange,
				handleMessageSend,
				uploadProps,
				roleConfig,
			};
		},
	};
</script>

<style>
	.inputBoxStyle {
		background-color: pink;
	}

	.previous {
		width: 30px;
		height: 30px;
		position: fixed;
		left: 20px;
		top: 20px;
		z-index: 100;
	}

	.previous-img {
		width: 30px;
		height: 30px;
	}
</style>