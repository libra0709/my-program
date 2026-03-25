<template>
	<div>
		<div class="login-container">
			<el-form class="login_form animate__animated animate__zoomInUp">
				<div class="login_form2">
					<div class="title-container">顺丰仓储管理信息系统的开发与应用</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							<span class="icon iconfont icon-touxiang09"></span>
						</div>
						<input placeholder="请输入账号：" name="username" type="text" v-model="rulesForm.username">
					</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							<span class="icon iconfont icon-chakan13"></span>
						</div>
						<div class="password-box">
							<input placeholder="请输入密码：" name="password" :type="showPassword?'text':'password'" v-model="rulesForm.password">
							<span class="icon iconfont" :class="showPassword?'icon-liulan13':'icon-liulan17'" @click="showPassword=!showPassword"></span>
						</div>
					</div>

					<div class="list-item select" v-if="roles.length>1">
						<div class="lable">
							<span class="icon iconfont icon-touxiang15"></span>
						</div>
						<el-select v-model="rulesForm.role" placeholder="请选择角色：">
							<el-option v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" :key="item.roleName" :label="item.roleName" :value="item.roleName" />
						</el-select>
					</div>

		
					<div class="login-btn">
						<div class="login-btn1">
							<el-button v-if="loginType==1" type="primary" @click="login()" class="loginInBt">登录</el-button>
						</div>
						<div class="login-btn2">
							<el-button type="primary" @click="register('yonghu')" class="register">
								注册用户							</el-button>
						</div>
						<div class="login-btn3">
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>
<script>
	import 'animate.css'
	import menu from "@/utils/menu";
	export default {
		data() {
			return {
				verifyCheck2: false,
				flag: false,
				baseUrl:this.$base.url,
				loginType: 1,
				rulesForm: {
					username: "",
					password: "",
					role: "",
				},
				menus: [],
				roles: [],
				tableName: "",
				showPassword: false,
			};
		},
		mounted() {
			this.getMenu();

		},
		created() {

		},
		destroyed() {
		},
		components: {
		},
		methods: {
			getMenu() {
				let params = {
					page: 1,
					limit: 1,
					sort: 'id',
				}

				this.$http({
					url: "menu/list",
					method: "get",
					params: params
				}).then(({
					data
				}) => {
					if (data && data.code === 0) {
						this.menus = JSON.parse(data.data.list[0].menujson);
						for (let i = 0; i < this.menus.length; i++) {
							if (this.menus[i].hasBackLogin=='是') {
								this.roles.push(this.menus[i])
							}
						}
						this.$storage.set("menus", this.menus);
					}
				})
			},

			//注册
			register(tableName){
				this.$storage.set("loginTable", tableName);
				this.$router.push({path:'/register',query:{pageFlag:'register'}})
			},
			// 登陆
			login() {

				if (!this.rulesForm.username) {
					this.$message.error("请输入用户名");
					return;
				}
				if (!this.rulesForm.password) {
					this.$message.error("请输入密码");
					return;
				}
				if(this.roles.length>1) {
					if (!this.rulesForm.role) {
						this.$message.error("请选择角色");
						return;
					}

					let menus = this.menus;
					for (let i = 0; i < menus.length; i++) {
						if (menus[i].roleName == this.rulesForm.role) {
							this.tableName = menus[i].tableName;
						}
					}
				} else {
					this.tableName = this.roles[0].tableName;
					this.rulesForm.role = this.roles[0].roleName;
				}
		
				this.loginPost()
			},
			loginPost() {
				this.$http({
					url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
					method: "post"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.$storage.set("Token", data.token);
						this.$storage.set("role", this.rulesForm.role);
						this.$storage.set("sessionTable", this.tableName);
						this.$storage.set("adminName", this.rulesForm.username);
						this.$nextTick(()=>{
							this.$http({
								url: this.tableName + '/session',
								method: "get"
							}).then(({
								data
							}) => {
								if (data && data.code === 0) {
									if(this.tableName == 'yonghu') {
										this.$storage.set('headportrait',data.data.touxiang)
									}
									if(this.tableName == 'cangguan') {
										this.$storage.set('headportrait',data.data.touxiang)
									}
									if(this.tableName == 'siji') {
										this.$storage.set('headportrait',data.data.touxiang)
									}
									if(this.tableName == 'users') {
										this.$storage.set('headportrait',data.data.image)
									}
									this.$storage.set('userForm',JSON.stringify(data.data))
									this.$storage.set('userid',data.data.id);
								} else {
									let message = this.$message
									message.error(data.msg);
								}
								this.$router.replace({ path: "/" });
							});
						})
					} else {
						this.$message.error(data.msg);
					}
				});
			},
		}
	}
</script>

<style lang="scss" scoped>
.login-container {
	min-height: 100vh;
	position: relative;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	background-repeat: no-repeat;
	background-size: 100% 100%;
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: flex-start;
	align-items: center;
	background-image: url(http://codegen.caihongy.cn/20241009/993c5de7cce9444e914f70646d08a001.png);
	background-position: center center;
	position: relative;

	.login_form {
		padding: 20px;
		margin: 0;
		z-index: 1000;
		display: flex;
		min-height: 50vh;
		flex-wrap: wrap;
		border-radius: 10px 10px;
		box-shadow: 0px -20px 0px 0px #1C5717;
		top: 30%;
		left: 9%;
		background: #fff;
		width: 28%;
		align-items: center;
		position: absolute;
		.login_form2 {
			display: flex;
			width: 100%;
			flex-wrap: wrap;
		}
		.title-container {
			padding: 0 20px;
			margin: 0 0 20px 0;
			color: #fff;
			top: -120px;
			left: 0;
			background: none;
			font-weight: 600;
			width: 250%;
			font-size: 32px;
			line-height: 40px;
			position: absolute;
			text-align: left;
		}
		.list-item {
			border: 1px solid #298026;
			border-radius: 5px;
			padding: 0 10px 0 20px;
			margin: 0 0 20px;
			display: flex;
			width: calc(100% - 0px);
			align-items: center;
			position: relative;
			.lable {
				color: #000;
				width: 50px;
				font-size: 14px;
				line-height: 40px;
				text-align: left;
				.icon {
					color: #000;
					width: auto;
					font-size: 18px;
					line-height: 44px;
					text-align: center;
				}
			}
			input {
				border: 0px solid #efeff7;
				border-radius: 4px;
				padding: 0 10px;
				color: #666;
				width: 100%;
				font-size: 16px;
				line-height: 44px;
				height: 44px;
			}
			input:focus {
				border: 0px solid #efeff7;
				padding: 0 10px;
				color: #000;
				width: 100%;
				font-size: 16px;
				line-height: 44px;
				height: 44px;
			}
			.password-box {
				display: flex;
				width: 100%;
				position: relative;
				align-items: center;
				input {
					border: 0px solid #efeff7;
					padding: 0 10px;
					color: #666;
					width: 100%;
					font-size: 16px;
					height: 44px;
				}
				input:focus {
					border: 0px solid #efeff7;
					padding: 0 10px;
					color: #000;
					width: 100%;
					font-size: 16px;
					height: 44px;
				}
				.iconfont {
					cursor: pointer;
					z-index: 1;
					color: #000;
					top: 0;
					font-size: 16px;
					line-height: 44px;
					position: absolute;
					right: 5px;
				}
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
			/deep/ .el-select {
				width: 100%;
			}
			/deep/ .el-select .el-input__inner {
				border: 0px solid rgba(64, 158, 255, 1);
				padding: 0 10px;
				color: #666;
				width: 288px;
				font-size: 16px;
				line-height: 44px;
				height: 44px;
			}
			/deep/ .el-select .is-focus .el-input__inner {
				border: 0px solid rgba(85, 170, 0, 1.0);
				padding: 0 10px;
				color: #000;
				width: 288px;
				font-size: 16px;
				line-height: 44px;
				height: 44px;
			}
			/deep/ .el-select .el-input__inner::placeholder{
				color: #999;
				font-size: 16px;
			}
		}
		.login-btn {
			margin: 20px auto 0;
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			flex-wrap: wrap;
			.login-btn1 {
				width: 50%;
			}
			.login-btn2 {
				border-radius: 10px;
				padding: 20px 0 0;
				top: calc(100% + 10px);
				background: #fff;
				display: flex;
				width: 100%;
				justify-content: space-around;
				align-items: center;
				position: absolute;
				flex-wrap: wrap;
				height: 14vh;
			}
			.login-btn3 {
				display: flex;
				width: 50%;
				justify-content: flex-end;
			}
			.loginInBt {
				border: 0px solid rgba(0, 0, 0, 1);
				cursor: pointer;
				border-radius: 30px;
				padding: 0 10px;
				margin: 0 0 10px;
				color: #fff;
				background: #298026;
				font-weight: 600;
				width: 60%;
				font-size: 26px;
				line-height: 2;
			}
			.loginInBt:hover {
				opacity: 0.8;
			}
			.register {
				border: 1px solid #174514;
				cursor: pointer;
				border-radius: 10px;
				padding: 0 10px;
				margin: 0 0 10px;
				color: #174514;
				background: #fff;
				width: 30%;
				font-size: 18px;
				height: 50px;
			}
			.register:hover {
				opacity: 0.8;
			}
			.forget {
				border: 1px solid #174514;
				cursor: pointer;
				border-radius: 30px;
				padding: 0;
				margin: 0 10px 10px 0;
				color: #1C5717;
				background: none;
				width: 40%;
				font-size: 13px;
				text-align: center;
				height: 30px;
			}
			.forget:hover {
				opacity: 0.8;
			}
		}
	}
}

</style>
