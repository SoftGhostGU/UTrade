import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useSkillStore = defineStore('skill', () => {
  const skills = ref([
    {
      cover: '/static/PR.png',
      label: '推荐',
      title: 'PR剪辑',
      avater: '/static/PRer.png',
      username: '张伟',
    },
    {
      cover: '/static/pic.png',
      label: '直播中',
      title: '摄影',
      avater: '/static/picer.png',
      username: '李华',
    },
    {
      cover: '/static/cook.png',
      label: '热门',
      title: '厨艺',
      avater: '/static/cooker.png',
      username: '赵敏',
    },
    {
      cover: '/static/tatennis.png',
      label: '推荐',
      title: '乒乓球',
      avater: '/static/tatenniser.png',
      username: '王强',
    }
  ])

  function addSkill(newSkill) {
    const labels = ['推荐', '直播中', '热门']
    const randomLabel = labels[Math.floor(Math.random() * labels.length)]
    
    const skillToAdd = {
      cover: newSkill.imageUrl,
      label: randomLabel,
      title: newSkill.skillTitle,
      avater: '/static/PRer.png',
      username: '张伟'
    }
    
    skills.value.unshift(skillToAdd)
  }

  return {
    skills,
    addSkill
  }
})