<template>
	<v-container >
		<h2>공지사항</h2>
		<gongzi-read/>
	</v-container>
</template>

<script>
import GongziRead from '@/components/gongzi/GongziRead.vue'
import { mapActions } from 'vuex'

export default {
	name: 'GongziReadPage',
	components: {
		GongziRead
	},
	data () {
		return {
			gongziNo: null
		}
	},
	mounted () {
		this.gongziNo = this.$route.query.gongziNo
		this.fetchGongzi(this.gongziNo)
	},
	methods: {
		...mapActions(['fetchGongzi']),
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

