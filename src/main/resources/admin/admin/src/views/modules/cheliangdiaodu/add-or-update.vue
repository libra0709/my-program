<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'"  label="车辆名称" prop="cheliangmingcheng" >
					<el-input v-model="ruleForm.cheliangmingcheng" placeholder="车辆名称" clearable  :readonly="ro.cheliangmingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="车辆名称" prop="cheliangmingcheng" >
					<el-input v-model="ruleForm.cheliangmingcheng" placeholder="车辆名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="车牌号码" prop="chepaihaoma" >
					<el-input v-model="ruleForm.chepaihaoma" placeholder="车牌号码" clearable  :readonly="ro.chepaihaoma"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="车牌号码" prop="chepaihaoma" >
					<el-input v-model="ruleForm.chepaihaoma" placeholder="车牌号码" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.cheliangtupian" label="车辆图片" prop="cheliangtupian" >
					<file-upload
						tip="点击上传车辆图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.cheliangtupian?ruleForm.cheliangtupian:''"
						@change="cheliangtupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.cheliangtupian" label="车辆图片" prop="cheliangtupian" >
					<img v-if="ruleForm.cheliangtupian.substring(0,4)=='http'&&ruleForm.cheliangtupian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.cheliangtupian" width="100" height="100">
					<img v-else-if="ruleForm.cheliangtupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.cheliangtupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.cheliangtupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="载重类型" prop="zaizhongleixing" >
					<el-input v-model="ruleForm.zaizhongleixing" placeholder="载重类型" clearable  :readonly="ro.zaizhongleixing"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="载重类型" prop="zaizhongleixing" >
					<el-input v-model="ruleForm.zaizhongleixing" placeholder="载重类型" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="调度时间" prop="diaodushijian" >
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.diaodushijian" 
						type="date"
						:readonly="ro.diaodushijian"
						placeholder="调度时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.diaodushijian" label="调度时间" prop="diaodushijian" >
					<el-input v-model="ruleForm.diaodushijian" placeholder="调度时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'" label="司机账号" prop="sijizhanghao" >
					<el-select :disabled="ro.sijizhanghao" @change="sijizhanghaoChange" v-model="ruleForm.sijizhanghao" placeholder="请选择司机账号">
						<el-option
							v-for="(item,index) in sijizhanghaoOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.sijizhanghao" label="司机账号" prop="sijizhanghao" >
					<el-input v-model="ruleForm.sijizhanghao" placeholder="司机账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="司机姓名" prop="sijixingming" >
					<el-input v-model="ruleForm.sijixingming" placeholder="司机姓名" clearable  :readonly="ro.sijixingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="司机姓名" prop="sijixingming" >
					<el-input v-model="ruleForm.sijixingming" placeholder="司机姓名" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="textarea" v-if="type!='info'" label="调度原因" prop="diaoduyuanyin" >
				<el-input
					style="min-width: 200px; max-width: 600px;"
					type="textarea"
					:rows="8"
					placeholder="调度原因"
					v-model="ruleForm.diaoduyuanyin" >
				</el-input>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.diaoduyuanyin" label="调度原因" prop="diaoduyuanyin" >
				<span class="text">{{ruleForm.diaoduyuanyin}}</span>
			</el-form-item>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	export default {
		data() {
			return {
				id: '',
				type: '',
			
			
				ro:{
					cheliangmingcheng : false,
					chepaihaoma : false,
					cheliangtupian : false,
					zaizhongleixing : false,
					diaodushijian : false,
					diaoduyuanyin : false,
					sijizhanghao : false,
					sijixingming : false,
				},
			
				ruleForm: {
					cheliangmingcheng: '',
					chepaihaoma: '',
					cheliangtupian: '',
					zaizhongleixing: '',
					diaodushijian: '',
					diaoduyuanyin: '',
					sijizhanghao: '',
					sijixingming: '',
				},
				sijizhanghaoOptions: [],

				rules: {
					cheliangmingcheng: [
					],
					chepaihaoma: [
					],
					cheliangtupian: [
					],
					zaizhongleixing: [
					],
					diaodushijian: [
					],
					diaoduyuanyin: [
					],
					sijizhanghao: [
					],
					sijixingming: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {



		},
		components: {
		},
		created() {
			this.ruleForm.diaodushijian = this.getCurDate()
		},
		methods: {
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					for(let x in this.ro) {
						this.ro[x] = true
					}
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o=='cheliangmingcheng'){
							this.ruleForm.cheliangmingcheng = obj[o];
							this.ro.cheliangmingcheng = true;
							continue;
						}
						if(o=='chepaihaoma'){
							this.ruleForm.chepaihaoma = obj[o];
							this.ro.chepaihaoma = true;
							continue;
						}
						if(o=='cheliangtupian'){
							this.ruleForm.cheliangtupian = obj[o];
							this.ro.cheliangtupian = true;
							continue;
						}
						if(o=='zaizhongleixing'){
							this.ruleForm.zaizhongleixing = obj[o];
							this.ro.zaizhongleixing = true;
							continue;
						}
						if(o=='diaodushijian'){
							this.ruleForm.diaodushijian = obj[o];
							this.ro.diaodushijian = true;
							continue;
						}
						if(o=='diaoduyuanyin'){
							this.ruleForm.diaoduyuanyin = obj[o];
							this.ro.diaoduyuanyin = true;
							continue;
						}
						if(o=='sijizhanghao'){
							this.ruleForm.sijizhanghao = obj[o];
							this.ro.sijizhanghao = true;
							continue;
						}
						if(o=='sijixingming'){
							this.ruleForm.sijixingming = obj[o];
							this.ro.sijixingming = true;
							continue;
						}
					}
				}
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(((json.chepaihaoma!=''&&json.chepaihaoma) || json.chepaihaoma==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.chepaihaoma = json.chepaihaoma
							this.ro.chepaihaoma = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
				this.$http({
					url: `option/siji/sijizhanghao`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.sijizhanghaoOptions = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 下二随
			sijizhanghaoChange () {
				this.$http({
					url: `follow/siji/sijizhanghao?columnValue=`+ this.ruleForm.sijizhanghao,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.sijixingming){
							this.ruleForm.sijixingming = data.data.sijixingming
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `cheliangdiaodu/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.cheliangtupian!=null) {
						this.ruleForm.cheliangtupian = this.ruleForm.cheliangtupian.replace(new RegExp(this.$base.url,"g"),"");
					}
					var objcross = this.$storage.getObj('crossObj');
					if(!this.ruleForm.id) {
						delete this.ruleForm.userid
					}
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							
							await this.$http({
								url: `cheliangdiaodu/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.cheliangdiaoduCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});
						}
					});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.cheliangdiaoduCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			cheliangtupianUploadChange(fileUrls) {
				this.ruleForm.cheliangtupian = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 30px;
		box-shadow: 0 4px 8px #1C5717;
		margin: 20px 0 20px 40px;
		background: #fff;
		width: calc(100% - 60px);
	}
	.add-update-preview {
		padding: 0 30% 0 15%;
		border-color: #eee;
		border-width: 0px 0 0;
		border-style: solid;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 0;
		margin: 0 0 26px 0;
		display: inline-block;
		width: 100%;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #9E9E9E;
		font-weight: 600;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	.add-update-preview .el-form-item span.text {
		padding: 0 10px;
		color: #333;
		background: none;
		font-weight: 500;
		display: inline-block;
		font-size: 16px;
		line-height: 40px;
		min-width: 50%;
	}
	
	.add-update-preview .el-input {
		width: 100%;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 12px;
		color: #000;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 1px solid #E8E8E8;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #000;
		background: #ccc;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 12px;
		color: #000;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 1px solid #E8E8E8;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #000;
		background: #ccc;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 100%;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 10px;
		color: #000;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 1px solid #E8E8E8;
		cursor: not-allowed;
		border-radius: 0;
		padding: 0 10px;
		color: #000;
		background: #ccc;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-date-editor {
		width: 100%;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #000;
		background: #fff;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 1px solid #E8E8E8;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #000;
		background: #ccc;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .viewBtn {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 25px;
		margin: 0 20px 0 0;
		color: #fff;
		background: #53DEBB;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			display: none;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 25px;
		margin: 0 20px 0 0;
		color: #fff;
		background: #1C5717;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			display: none;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 25px;
		margin: 0 20px 0 0;
		color: #fff;
		background: #8EC17D;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 1;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #999;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #999;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 1px solid #E8E8E8;
		cursor: pointer;
		border-radius: 0px;
		color: #999;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #999;
		font-size: 15px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 1px solid #E8E8E8;
		border-radius: 0px;
		padding: 12px;
		color: #000;
		background: #fff;
		width: 100%;
		font-size: 14px;
		height: 120px;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border: 0;
				cursor: not-allowed;
				border-radius: 0px;
				padding: 12px;
				color: #000;
				background: #ccc;
				width: 100%;
				font-size: 14px;
				height: 120px;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 0;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #1C5717;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 0;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #FCBB78;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 0;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #969C2D;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 0;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #8EC17D;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 0;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #53DEBB;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>
