<template>
	<div>
		<div class="register-container">
			<el-form v-if="pageFlag=='register'" ref="ruleForm" class="rgs-form animate__animated animate__zoomInDown" :model="ruleForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">顺丰仓储管理信息系统的开发与应用</div>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('yonghuzhanghao')?'required':''">用户账号：</div>
						<el-input  v-model="ruleForm.yonghuzhanghao"  autocomplete="off" placeholder="用户账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('yonghuxingming')?'required':''">用户姓名：</div>
						<el-input  v-model="ruleForm.yonghuxingming"  autocomplete="off" placeholder="用户姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('shoujihaoma')?'required':''">手机号码：</div>
						<el-input  v-model="ruleForm.shoujihaoma"  autocomplete="off" placeholder="手机号码"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in yonghuxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input  v-model.number="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="yonghutouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('dizhi')?'required':''">地址：</div>
						<el-input  v-model="ruleForm.dizhi"  autocomplete="off" placeholder="地址"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='cangguan'">
						<div class="lable" :class="changeRules('cangguanzhanghao')?'required':''">仓管账号：</div>
						<el-input  v-model="ruleForm.cangguanzhanghao"  autocomplete="off" placeholder="仓管账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='cangguan'">
						<div class="lable" :class="changeRules('cangguanxingming')?'required':''">仓管姓名：</div>
						<el-input  v-model="ruleForm.cangguanxingming"  autocomplete="off" placeholder="仓管姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='cangguan'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='cangguan'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='cangguan'">
						<div class="lable" :class="changeRules('lianxifangshi')?'required':''">联系方式：</div>
						<el-input  v-model="ruleForm.lianxifangshi"  autocomplete="off" placeholder="联系方式"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='cangguan'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in cangguanxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='cangguan'">
						<div class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input  v-model.number="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='cangguan'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="cangguantouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='siji'">
						<div class="lable" :class="changeRules('sijizhanghao')?'required':''">司机账号：</div>
						<el-input  v-model="ruleForm.sijizhanghao"  autocomplete="off" placeholder="司机账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='siji'">
						<div class="lable" :class="changeRules('sijixingming')?'required':''">司机姓名：</div>
						<el-input  v-model="ruleForm.sijixingming"  autocomplete="off" placeholder="司机姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='siji'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='siji'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='siji'">
						<div class="lable" :class="changeRules('shoujihaoma')?'required':''">手机号码：</div>
						<el-input  v-model="ruleForm.shoujihaoma"  autocomplete="off" placeholder="手机号码"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='siji'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in sijixingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='siji'">
						<div class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input  v-model.number="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='siji'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="sijitouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='siji'">
						<div class="lable" :class="changeRules('jiashizheng')?'required':''">驾驶证：</div>
						<el-input  v-model="ruleForm.jiashizheng"  autocomplete="off" placeholder="驾驶证"  type="text"  />
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">注册</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，直接登录</div>
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	import 'animate.css'
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            yonghuxingbieOptions: [],
            cangguanxingbieOptions: [],
            sijixingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='yonghu'){
				this.ruleForm = {
					yonghuzhanghao: '',
					yonghuxingming: '',
					mima: '',
					shoujihaoma: '',
					xingbie: '',
					nianling: '',
					touxiang: '',
					dizhi: '',
				}
			}
			if(this.tableName=='cangguan'){
				this.ruleForm = {
					cangguanzhanghao: '',
					cangguanxingming: '',
					mima: '',
					lianxifangshi: '',
					xingbie: '',
					nianling: '',
					touxiang: '',
				}
			}
			if(this.tableName=='siji'){
				this.ruleForm = {
					sijizhanghao: '',
					sijixingming: '',
					mima: '',
					shoujihaoma: '',
					xingbie: '',
					nianling: '',
					touxiang: '',
					jiashizheng: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('cangguan' == this.tableName) {
				this.rules.cangguanzhanghao = [{ required: true, message: '请输入仓管账号', trigger: 'blur' }]
			}
			if ('cangguan' == this.tableName) {
				this.rules.cangguanxingming = [{ required: true, message: '请输入仓管姓名', trigger: 'blur' }]
			}
			if ('cangguan' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('siji' == this.tableName) {
				this.rules.sijizhanghao = [{ required: true, message: '请输入司机账号', trigger: 'blur' }]
			}
			if ('siji' == this.tableName) {
				this.rules.sijixingming = [{ required: true, message: '请输入司机姓名', trigger: 'blur' }]
			}
			if ('siji' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',')
			this.cangguanxingbieOptions = "男,女".split(',')
			this.sijixingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yonghutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        cangguantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        sijitouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
			if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
				this.$message.error(`用户账号不能为空`);
				return
			}
			if((!this.ruleForm.yonghuxingming) && `yonghu` == this.tableName){
				this.$message.error(`用户姓名不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `yonghu` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `yonghu` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if(`yonghu` == this.tableName && this.ruleForm.shoujihaoma &&(!this.$validate.isMobile(this.ruleForm.shoujihaoma))){
				this.$message.error(`手机号码应输入手机格式`);
				return
			}
			if(`yonghu` == this.tableName && this.ruleForm.nianling &&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.cangguanzhanghao) && `cangguan` == this.tableName){
				this.$message.error(`仓管账号不能为空`);
				return
			}
			if((!this.ruleForm.cangguanxingming) && `cangguan` == this.tableName){
				this.$message.error(`仓管姓名不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `cangguan` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `cangguan` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if(`cangguan` == this.tableName && this.ruleForm.lianxifangshi &&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
				this.$message.error(`联系方式应输入手机格式`);
				return
			}
			if(`cangguan` == this.tableName && this.ruleForm.nianling &&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.sijizhanghao) && `siji` == this.tableName){
				this.$message.error(`司机账号不能为空`);
				return
			}
			if((!this.ruleForm.sijixingming) && `siji` == this.tableName){
				this.$message.error(`司机姓名不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `siji` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `siji` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if(`siji` == this.tableName && this.ruleForm.shoujihaoma &&(!this.$validate.isMobile(this.ruleForm.shoujihaoma))){
				this.$message.error(`手机号码应输入手机格式`);
				return
			}
			if(`siji` == this.tableName && this.ruleForm.nianling &&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.register-container {
	position: relative;
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
	.rgs-form {
		.rgs-form2 {
		overflow: auto;
		width: 100%;
		height: 62vh;
		}
		padding: 20px;
		margin: 0;
		z-index: 1000;
		display: flex;
		flex-wrap: wrap;
		border-radius: 10px 10px;
		box-shadow: 0px -20px 0px 0px #1C5717;
		flex-direction: column;
		top: 30%;
		left: 9%;
		background: #fff;
		width: 28%;
		align-items: flex-start;
		position: absolute;
		height: auto;
		.title {
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
			padding: 0 0 0 0px;
			margin: 0 0 10px;
			display: flex;
			width: 100%;
			align-items: center;
			position: relative;
			height: auto;
			/deep/ .el-form-item__content {
				border: 1px solid #298026;
				border-radius: 5px;
				padding: 0 0 0 10px;
				display: flex;
				width: 100%;
				align-items: center;
			}
			.lable {
				padding: 0;
				color: #333;
				width: 100px;
				font-size: 13px;
				line-height: 34px;
				text-align: left;
			}
			.el-input {
				width: calc(100% - 100px);
			}
			.el-input /deep/ .el-input__inner {
				border: 0px solid #efeff7;
				border-radius: 4px;
				padding: 0 10px;
				color: #666;
				width: 100%;
				font-size: 14px;
				height: 38px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border: 0px solid #efeff7;
				border-radius: 4px;
				padding: 0 10px;
				color: #000;
				width: 100%;
				font-size: 14px;
				height: 38px;
			}
			.el-input-number {
				width: calc(100% - 100px);
			}
			.el-input-number /deep/ .el-input__inner {
				text-align: center;
				border: 0px solid #efeff7;
				border-radius: 4px;
				padding: 0 10px;
				color: #666;
				width: 100%;
				font-size: 14px;
				height: 38px;
			}
			.el-input-number /deep/ .el-input__inner:focus {
				border: 0px solid #efeff7;
				border-radius: 4px;
				padding: 0 10px;
				color: #000;
				width: 100%;
				font-size: 14px;
				height: 38px;
			}
			.el-input-number /deep/ .el-input-number__decrease {
				display: none;
			}
			.el-input-number /deep/ .el-input-number__increase {
				display: none;
			}
			.el-select {
				width: calc(100% - 100px);
			}
			.el-select /deep/ .el-input__inner {
				border: 0px solid #efeff7;
				border-radius: 0;
				padding: 0 10px;
				color: #666;
				width: 100%;
				font-size: 14px;
				height: 38px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border: 0px solid #efeff7;
				border-radius: 5px;
				padding: 0 10px;
				color: #000;
				width: 100%;
				font-size: 16px;
				height: 38px;
			}
			.el-date-editor {
				width: calc(100% - 100px);
			}
			.el-date-editor /deep/ .el-input__inner {
				border: 0px solid #efeff7;
				border-radius: 0;
				padding: 0 10px 0 30px;
				color: #666;
				width: 100%;
				font-size: 14px;
				height: 38px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border: 0px solid #efeff7;
				border-radius: 0;
				padding: 0 10px 0 30px;
				color: #000;
				width: 100%;
				font-size: 14px;
				height: 38px;
			}
			.el-date-editor.el-input {
				width: 100%;
			}
			/deep/ .el-upload--picture-card {
				background: transparent;
				border: 0;
				border-radius: 0;
				width: auto;
				height: auto;
				line-height: initial;
				vertical-align: middle;
			}
			/deep/ .upload .upload-img {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				margin: 5px 0 0;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				margin: 5px 0 0;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				margin: 5px 0 0;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload__tip {
				color: #9e9e9e;
				font-size: 12px;
			}
			/deep/ .el-input__inner::placeholder {
				color: #999;
				font-size: 14px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				left: 0;
				position: inherit;
				content: "*";
				order: -1;
			}
			.editor {
				background: #fff;
				width: calc(100% - 100px);
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border: 0px solid #efeff7;
				border-radius: 4px 0 0 4px;
				padding: 0 10px;
				margin: 0;
				color: #666;
				background: #fff;
				flex: 1;
				width: 100%;
				font-size: 14px;
				height: 38px;
			}
			input:focus {
				border: 0px solid #efeff7;
				border-radius: 4px 0 0 4px;
				padding: 0 10px;
				color: #000;
				width: 100%;
				font-size: 14px;
				height: 38px;
			}
			input::placeholder {
				color: #999;
				font-size: 14px;
			}
			button {
				border: 0px solid #efeff7;
				cursor: pointer;
				border-radius: 0 4px 4px 0;
				padding: 0;
				margin: 0;
				color: #fff;
				background: #298026;
				width: 150px;
				font-size: 15px;
				height: 38px;
			}
			button:hover {
				opacity: 0.5;
			}
		}
		.register-btn {
			margin: 20px 0;
			display: flex;
			width: 100%;
			align-items: center;
		}
		.register-btn1 {
			width: 50%;
		}
		.register-btn2 {
			display: flex;
			width: 50%;
			justify-content: flex-end;
		}
		.r-btn {
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
			min-width: 68px;
			height: 50px;
		}
		.r-btn:hover {
			border: 0px solid rgba(0, 0, 0, 1);
			opacity: 0.8;
		}
		.r-login {
			border: 1px solid #174514;
			cursor: pointer;
			border-radius: 30px;
			padding: 0;
			margin: 0 10px 10px 0;
			color: #1C5717;
			background: none;
			width: 100%;
			font-size: 16px;
			line-height: 40px;
			text-align: center;
			height: 40px;
		}
		.r-login:hover {
			opacity: 1;
		}
	}
}
	
	::-webkit-scrollbar {
	  display: none;
	}
</style>
