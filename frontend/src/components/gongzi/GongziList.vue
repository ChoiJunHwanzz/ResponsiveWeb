<template>
	<v-sheet >
		<v-data-table
			:headers="headerTitle"
			:items="gongzis"
			:items-per-page="10"
			class="gongziTable"
			@click:row="readGongzi">
		</v-data-table>
	</v-sheet>
</template>


<script>

export default {
  name: 'GongziList',
	data() {
		return {
			headerTitle: [
				{ text: '번호', value: 'gongziNo', width: "30px" },
				{ text: '제목', value: 'title', width: "300px" },
				// { text: '작성자', value: 'writer', width: "70px" },
				{ text: '작성일자', value: 'createdDate', width: "70px" },
				{ text: '조회수', value: 'view', width: "70px" },

			],
		}
	},
	props: {
		gongzis: {

		}
	},
	methods: {
		readGongzi(gongzi) {
			console.log(gongzi)
			this.$router.push(
				{ name: 'GongziReadPage', query: { gongziNo: gongzi.gongziNo } }
			)
		}
	}
}
</script>

<style scoped>
	.gongziTable{
		box-shadow: none;
		border-top: 1px solid #555;
		border-radius: 0;
		margin-top: 50px;
	}



</style>
