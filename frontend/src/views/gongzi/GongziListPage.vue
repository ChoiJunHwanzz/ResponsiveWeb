<template>
	<v-container>
		<h2>공지사항</h2>
		<v-btn  @click="gongziRegister" outlined class="float-right">글쓰기</v-btn>
		<gongzi-list :gongzis="gongzis"/>
	</v-container>
</template>

<script>
import GongziList from '@/components/gongzi/GongziList.vue'
import { mapState, mapActions } from 'vuex'

export default {
	name: 'GongziListPage',
	components: {
		GongziList
	},
	data() {
		return{
		}
	},
	computed: {
		...mapState(['gongzis'])
	},
	mounted () {
		this.fetchGongziList()
		if (this.userInfo.authList) {
			if (this.userInfo.authList[0].auth == '관리자') {
				this.auth = 1
			}
		}
	},
	methods: {
		...mapActions(['fetchGongziList']),
		gongziRegister() {
			this.$router.push({ name: 'GongziRegisterPage' })
		}
	}
}
</script>

<style scoped>

	* {
		font-family: 'Noto Sans KR', sans-serif;
	}

	.container {
		margin-top: 80px;
	}

	h2 {
		font-size: 33px;
		/*font-weight: bold;*/
		width: 100%;
		color: #000;
	}

</style>
