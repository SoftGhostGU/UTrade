<script setup>
import { ref, nextTick } from 'vue'
import { useSkillStore } from '@/store/skillStore'

const skills = ref([])
const skillIndex = ref(-1) // 添加跟踪选中技能的索引
const customSkill = ref('') // 自定义技能输入
const skillStore = useSkillStore()

const exchangeOptions = ref([])
const exchangeIndex = ref(-1) // 添加跟踪选中交换项的索引
const customExchange = ref('') // 自定义交换项输入

const skillOptions = ["PR剪辑", "乒乓球", "摄影", "其他"]
const exchangeItems = ["PR剪辑", "乒乓球", "摄影", "时间币", "其他"]
const iconImages = ref([
  "https://img.icons8.com/badges/48/sport.png",
  "https://img.icons8.com/color/50/sports.png",
  "https://img.icons8.com/clouds/50/stack-of-photos.png",
  "https://img.icons8.com/ios-filled/50/salt-bae.png",
  "https://img.icons8.com/plasticine/100/ping-pong--v1.png",
  "https://img.icons8.com/emoji/48/basketball-emoji.png",
  "https://img.icons8.com/emoji/48/martial-arts-uniform-emoji.png",
  "https://img.icons8.com/emoji/48/field-hockey-emoji.png"
])

const iconColors = ref([
  "#FFB6C1",  
  "#87CEFA", 
  "#98FB98",  
  "#DDA0DD",  
  "#FFD700",  
  "#FFA07A",  
  "#E0FFFF",  
  "#D3D3D3"   
])

// 显示选择其他技能的输入框
const showSkillInput = ref(false)
// 显示选择其他交换项的输入框
const showExchangeInput = ref(false)

// 处理技能选择变化
const handleSkillChange = (e) => {
  skillIndex.value = e.detail.value[0] // 保存索引
  skills.value = skillOptions[skillIndex.value] // 保存选中的值
  
  // 如果选择了"其他"，显示输入框并获得焦点
  if (skillIndex.value === skillOptions.length - 1) {
    showSkillInput.value = true
    customSkill.value = ''
    nextTick(() => {
      skillInput.value.focus()
    })
  } else {
    showSkillInput.value = false
    customSkill.value = ''
  }
}

// 处理交换项选择变化
const handleExchangeChange = (e) => {
  exchangeIndex.value = e.detail.value[0] // 保存索引
  exchangeOptions.value = exchangeItems[exchangeIndex.value] // 保存选中的值
  
  // 如果选择了"其他"，显示输入框并获得焦点
  if (exchangeIndex.value === exchangeItems.length - 1) {
    showExchangeInput.value = true
    customExchange.value = ''
    nextTick(() => {
      exchangeInput.value.focus()
    })
  } else {
    showExchangeInput.value = false
    customExchange.value = ''
  }
}

// 重置技能选择，回到选择框
const resetSkillSelection = () => {
  showSkillInput.value = false
  skillIndex.value = -1
  customSkill.value = ''
}

// 重置交换项选择，回到选择框
const resetExchangeSelection = () => {
  showExchangeInput.value = false
  exchangeIndex.value = -1
  customExchange.value = ''
}

// 上传图片的数组
const uploadedImages = ref([])

// 上传图片的方法
const uploadImage = () => {
  uni.chooseImage({
    count: 9 - uploadedImages.value.length, // 最多可以上传9张图片
    success: (res) => {
      uploadedImages.value = [...uploadedImages.value, ...res.tempFilePaths]
    }
  })
}

// 删除上传的图片
const deleteImage = (index) => {
  uploadedImages.value.splice(index, 1)
}

// 获取要显示的技能文本
const getSkillText = () => {
  if (skillIndex.value === -1) return '选择技能'
  if (skillIndex.value === skillOptions.length - 1 && customSkill.value) {
    return customSkill.value
  }
  return skillOptions[skillIndex.value]
}

// 获取要显示的交换项文本
const getExchangeText = () => {
  if (exchangeIndex.value === -1) return '选择内容'
  if (exchangeIndex.value === exchangeItems.length - 1 && customExchange.value) {
    return customExchange.value
  }
  return exchangeItems[exchangeIndex.value]
}

// 发布处理函数
const handlePublish = () => {
    if (uploadedImages.value.length === 0) {
        uni.showToast({
            title: '请上传示例图片',
            icon: 'none'
        });
        return;
    }

    if (skillIndex.value === -1) {
        uni.showToast({
            title: '请选择技能',
            icon: 'none'
        });
        return;
    }

    const newSkill = {
        imageUrl: uploadedImages.value[0],
        skillTitle: getSkillText()
    };
    
    // 使用 store 的方法添加技能
    skillStore.addSkill(newSkill);
    
    uni.showToast({
        title: '发布成功',
        icon: 'success',
        duration: 2000
    });
    
    // 修改这里，改用 switchTab 跳转到 home 页
    setTimeout(() => {
        uni.switchTab({
            url: '/pages/home/home'
        });
    }, 1500);
};
</script>

<template>
  <view class="total">
    <!-- 顶部导航 -->
    <view class="back">
      <text class="title">技能发布</text>
    </view>

    <!-- 信息区域（与图标浮层交界） -->
    <view class="info"></view>

    <!-- 技能图标盒子 -->
    <view class="icon-box">
      <!-- 使用图片路径数组循环渲染 -->
      <view 
        class="icon" 
        v-for="(img, index) in iconImages" 
        :key="index"
      >
        <img 
          :src="img" 
          :alt="'icon-' + index"
          class="icon-img"
          :style="{ backgroundColor: iconColors[index] }"
        />
      </view>
    </view>

    <!-- 内容区域 -->
    <view class="skill-details">
      <!-- 技能 -->
      <view class="section">
        <text class="label">技能</text>
        <!-- 正常选择框 - 在未选择"其他"时显示 -->
        <picker 
          v-if="!showSkillInput"
          mode="multiSelector" 
          :range="[skillOptions]" 
          @change="handleSkillChange">
          <view class="picker" :class="{ 'picker-selected': skillIndex !== -1 }">
            {{ getSkillText() }}
          </view>
        </picker>
        
        <!-- 如果选择了"其他"，直接显示输入框替代选择框 -->
        <view v-else class="input-container">
          <input 
            ref="skillInput"
            v-model="customSkill" 
            class="custom-input" 
            placeholder="请输入技能名称"
            @blur="() => showSkillInput = false" 
          />
          <text class="reset-btn" @click="resetSkillSelection">×</text>
        </view>
      </view>

      <!-- 想交换 -->
      <view class="section">
        <text class="label">想交换</text>
        <!-- 正常选择框 - 在未选择"其他"时显示 -->
        <picker 
          v-if="!showExchangeInput"
          mode="multiSelector" 
          :range="[exchangeItems]" 
          @change="handleExchangeChange">
          <view class="picker" :class="{ 'picker-selected': exchangeIndex !== -1 }">
            {{ getExchangeText() }}
          </view>
        </picker>
        
        <!-- 如果选择了"其他"，直接显示输入框替代选择框 -->
        <view v-else class="input-container">
          <input 
            ref="exchangeInput"
            v-model="customExchange" 
            class="custom-input" 
            placeholder="请输入交换内容"
            @blur="() => showExchangeInput = false" 
          />
          <text class="reset-btn" @click="resetExchangeSelection">×</text>
        </view>
      </view>

      <!-- 示例图上传 -->
      <view class="section">
        <text class="label">示例图</text>
        <view class="upload-container">
          <view 
            v-for="(image, index) in uploadedImages" 
            :key="index" 
            class="upload-box"
            @click="deleteImage(index)"
          >
            <img :src="image" class="uploaded-image" />
          </view>
          <view 
            v-if="uploadedImages.length < 9" 
            class="upload-box" 
            @click="uploadImage"
          >
            <text class="plus">+</text>
          </view>
        </view>
      </view>

      <!-- 发布按钮 -->
      <button class="publish-btn" @click="handlePublish">立即发布</button>
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
  justify-content: center;
  align-items: center;
}

.title {
  color: white;
  font-size: 1.2rem;
  font-weight: bold;
}

.info {
  width: 100%;
  height: 5rem;
}

.icon-box {
  position: absolute;
  top: 6rem;
  left: 10%;
  right: 10%;
  height: 8rem; /* 提高高度 */
  background-color: #fffffd;
  border-radius: 1rem;
  box-shadow: 0 2px 6px rgba(0,0,0,0.1);
  display: flex;
  flex-wrap: wrap; /* 允许换行 */
  justify-content: space-around;
  align-items: center;
  padding: 0.5rem 1rem;
  z-index: 10;
}

.icon {
  width: 2.5rem;
  height: 2.5rem;
  background-color: #eee;
  border-radius: 0.5rem;
  margin: 0.3rem 0.5rem; /* 间距设置 */
  overflow: hidden; /* 隐藏溢出部分 */
  position: relative; /* 为图片定位提供参考 */
}

.icon-img {
  width: 100%;
  height: 100%;
  object-fit: cover; /* 保持比例填充容器 */
  border-radius: 0.5rem; /* 继承父容器圆角 */
  display: block; /* 消除图片底部间隙 */
}

.skill-details {
  width: 100%;
  height: calc(100vh - 10rem);
  background-color: #fefefc;
  border-radius: 1.5rem 1.5rem 0 0;
  padding: 6.5rem 1.5rem 0;
  box-sizing: border-box;
  z-index: 1;
}

.section {
  margin-bottom: 2rem;
}

.label {
  font-size: 1rem;
  font-weight: 600;
  margin-bottom: 0.5rem;
  display: block;
}

.picker {
  background-color: #f5f5f6;
  padding: 0.6rem;
  border-radius: 1.5rem;
  color: #888;
}

/* 添加选中状态的样式 */
.picker-selected {
  color: #000;
  font-weight: 500;
}

/* 输入框容器 */
.input-container {
  position: relative;
  display: flex;
  align-items: center;
}

/* 自定义输入框样式 */
.custom-input {
  flex: 1;
  background-color: #f5f5f6;
  padding: 0.6rem;
  border-radius: 1.5rem;
  border: 1px solid #e0e0e0;
  font-size: 0.9rem;
}

/* 重置按钮 */
.reset-btn {
  position: absolute;
  right: 0.8rem;
  color: #888;
  font-size: 1.2rem;
  font-weight: bold;
  cursor: pointer;
}

.upload-container {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem;
}

.upload-box {
  width: 5rem;
  height: 5rem;
  border: 2px dashed #ccc;
  border-radius: 1rem;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #888;
  font-size: 2rem;
  margin-top: 0.5rem;
  position: relative;
  overflow: hidden;
}

.uploaded-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 1rem;
}

.plus {
  z-index: 1;
}

.delete-btn {
  position: absolute;
  top: 0.5rem;
  right: 0.5rem;
  background-color: rgba(0, 0, 0, 0.5);
  color: white;
  border-radius: 50%;
  width: 2rem;
  height: 2rem;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 1rem;
  cursor: pointer;
}

.publish-btn {
  margin-top: 4rem;
  width: 100%;
  background: linear-gradient(to right, #8a8ce7, #de80f3);
  color: white;
  font-weight: bold;
  font-size: 1rem;
  padding: 0.8rem;
  border-radius: 1.5rem;
}
</style>
