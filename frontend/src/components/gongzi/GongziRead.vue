<template>
  <v-sheet>
		<div class="detail_wrap">
			<div class="detail_inner">
				
				<div class="detail_title">
					
					<div class="detail_menu">
						<h1>{{ title }}</h1>
						<v-menu v-if="auth" offset-y>
							<template v-slot:activator="{ on, attrs }">
								<v-btn class="mt-1" v-on="on" v-bind="attrs" icon>
									<v-icon>mdi-dots-vertical</v-icon>
								</v-btn>
							</template>
							<v-list>
								<v-list-item @click="modifyGongzi">
									수정
								</v-list-item>
								<v-list-item @click="dialog = true">
									삭제
								</v-list-item>
							</v-list>
						</v-menu>
					</div>
					<div class="detail_subtitle">
						<span>{{ writer }}</span>
						<strong>{{ createdDate }}</strong>
						<em>조회수 <b>{{ view }}</b></em>
					</div>
				</div>

				<div class="detail_body">
					<p>{{ description }}</p>
				</div>

				<div class="detail-button">
					<b-button @click="gongziList" class="btn_list">목록</b-button>
				</div>
			</div>
		</div>

		<!--

		<v-card class="pa-3 my-5" color="grey lighten-4">
			<v-row>
				<v-col cols="12" md="11">
					<v-text-field v-model="title" solo readonly></v-text-field>
				</v-col>
				<v-col cols="12" md="1">
					<v-menu offset-y>
						<template v-slot:activator="{ on, attrs }">
							<v-btn class="mt-1" v-on="on" v-bind="attrs" icon>
								<v-icon>mdi-dots-vertical</v-icon>
							</v-btn>
						</template>
						<v-list>
							<v-list-item @click="modifyGongzi">
								수정
							</v-list-item>
							<v-list-item @click="dialog = true">
								삭제
							</v-list-item>
						</v-list>
					</v-menu>
				</v-col>
			</v-row>
	
			<v-textarea v-model="description" height="400" solo readonly></v-textarea>
	
			<v-card-actions>
				<div>
					<v-card-text class="caption my-n3">작성자 {{ gongzi.writer }}</v-card-text>
					<v-card-text class="caption mt-n6">작성일자 {{ gongzi.createdDate }}</v-card-text>
				</div>
				
				<v-spacer></v-spacer>
				<v-btn @click="gongziList" class="white">목록</v-btn>
			</v-card-actions>
		</v-card>
		-->

		<v-dialog v-model="dialog" width="400">
			<v-card>
				<v-card-title class="mb-10">정말 삭제하시겠습니까?</v-card-title>
				<v-card-actions>
					<v-btn @click="dialog = false" text>취소</v-btn>
					<v-spacer></v-spacer>
					<v-btn @click="deleteGongzi" text>확인</v-btn>
				</v-card-actions>
			</v-card>
		</v-dialog>
	</v-sheet>
</template>


<script>
import { mapState } from 'vuex'
import axios from 'axios'

export default {
	name: 'GongziRead',
	data () {
		return {
			dialog: false,
			title: null,
			description: null,
			writer: null,
			createdDate: null,
			view: null,
			auth: null
		}
	},
	computed: {
		...mapState(['gongzi', 'userInfo'])
	},
	mounted () {
		setTimeout(()=> {
			this.title = this.gongzi.title
			this.description = this.gongzi.description
			this.writer = this.gongzi.writer
			this.createdDate = this.gongzi.createdDate
			this.view = this.gongzi.view +1

			axios.post(`http://localhost:7777/gongzi/${this.gongzi.gongziNo}/${this.view}`).then(() => {
				console.log('view +1')
			})
		},100)

		if (this.userInfo.authList) {
			if (this.userInfo.authList[0].auth == '관리자') {
				this.auth = 1
			}
		}
	},
	methods: {
		modifyGongzi () {
			this.$router.push({ name: 'GongziModifyPage' })
		},
		deleteGongzi () {
			axios.delete(`http://localhost:7777/gongzi/${this.gongzi.gongziNo}`)
				.then(() => {
					alert('공지사항 삭제가 완료되었습니다.')
					this.$router.push({ name: 'GongziListPage' })
				})
				.catch(err => {
					alert(err.response.data.message)
				})
		},
		gongziList () {
			this.$router.push({ name: 'GongziListPage' })
		}
	}
}
</script>


<style scoped>
	.detail_wrap {
		width: 1200px;
		margin-top: 100px;
		margin: 0 auto;
		font-family: 'Gowun Dodum', sans-serif;
	}

	.detail_inner {
		width: 1000px;
	}

	a, em, strong, b {
		font-style: normal;
		font-weight: normal;
		text-decoration: none;
	}

	.detail_title {
		padding: 20px 0;
	}

	.detail_title h1 {
		color: rgb(99, 99, 99);
	}

	.detail_title .detail_menu {
		display: flex;
	}

	.detail_title .detail_subtitle {
		margin-top: 25px;
	}

	.detail_title .detail_subtitle span {
		font-weight: bold;
		margin-right: 25px;
		background: linear-gradient(to top, #a3f5a8 50%, transparent 50%);
	}

	.detail_title .detail_subtitle strong {
		font-size: 15px;
	}

	.detail_title .detail_subtitle em {
		float: right;
		font-size: 14px;
	}

	.detail_title .detail_subtitle em b {
		font-weight: bold;
		font-size: 15px;
	}

	/* 컨텐츠 */
	.detail_body {
		padding: 50px 10px;
		font-size: 18px;
		border-top: 1px solid rgba(0, 0, 0, .1);
		border-bottom: 1px solid rgba(0, 0, 0, .1);
		width: 100%;
		word-wrap:break-word;
		word-break:break-all;
	}

	/* 컨텐츠 버튼 */
	.detail-button {
		/*border: 1px solid red;*/
		padding: 15px 0;
	}

	.detail-button .btn {
		background-color: #fff;
		color: #000;
		border: 1px solid #bbb;
	}

	.detail-button .btn_modify {
		margin-right: 10px;
	}

	.detail-button .btn_delete {
		background-color: #f15c5c;
		color: #fff;
		border: 1px solid #f15c5c;
	}

	.detail-button .btn_list {
		float: right;
	}

	.detail-button:after {
		display: block;
		content: '';
		clear: both;
	}


	.content-detail-comment {
		border-top: 1px solid black;
		margin-top: 1rem;
		padding: 10px;
	}


	h1 {
		font-size: 33px;
		font-weight: bold;
		width: 100%;
		color: rgb(229, 119, 175);
	}

	.detail_inner > h1 {
		font-size: 22px;
	}

</style>