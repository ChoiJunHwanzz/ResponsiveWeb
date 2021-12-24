<template>
    <div>
        <v-container class="grey lighten-5 mb-6">
            <v-row justify="start" no-gutters>
                <v-card class="pa-6" outlined tile>
                    <v-btn  @click="gongziList" outlined class="float-right">공지사항</v-btn>
                </v-card>
                <v-card class="pa-6" outlined tile>column</v-card>
            </v-row>
        </v-container>
    </div>
</template>
<script>
export default {
    methods: {
		gongziList() {
			this.$router.push({ name: 'GongziListPage' })
		}
	}
    
}
</script>
<style scoped>
    .card{
        display: flex;
        width : 300px;
        height: 200px;
        margin-left: 30px;

    }
</style>