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
				<el-form-item class="upload" v-if="type!='info' && !ro.weibaotupian" label="维保图片" prop="weibaotupian" >
					<file-upload
						tip="点击上传维保图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.weibaotupian?ruleForm.weibaotupian:''"
						@change="weibaotupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.weibaotupian" label="维保图片" prop="weibaotupian" >
					<img v-if="ruleForm.weibaotupian.substring(0,4)=='http'&&ruleForm.weibaotupian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.weibaotupian" width="100" height="100">
					<img v-else-if="ruleForm.weibaotupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.weibaotupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.weibaotupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="载重类型" prop="zaizhongleixing" >
					<el-input v-model="ruleForm.zaizhongleixing" placeholder="载重类型" clearable  :readonly="ro.zaizhongleixing"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="载重类型" prop="zaizhongleixing" >
					<el-input v-model="ruleForm.zaizhongleixing" placeholder="载重类型" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="荷载重量" prop="hezaizhongliang" >
					<el-input v-model="ruleForm.hezaizhongliang" placeholder="荷载重量" clearable  :readonly="ro.hezaizhongliang"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="荷载重量" prop="hezaizhongliang" >
					<el-input v-model="ruleForm.hezaizhongliang" placeholder="荷载重量" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="维保进度" prop="weibaojindu" >
					<el-select :disabled="ro.weibaojindu" v-model="ruleForm.weibaojindu" placeholder="请选择维保进度" >
						<el-option
							v-for="(item,index) in weibaojinduOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="维保进度" prop="weibaojindu" >
					<el-input v-model="ruleForm.weibaojindu"
						placeholder="维保进度" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="维保时间" prop="weibaoshijian" >
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.weibaoshijian" 
						type="date"
						:readonly="ro.weibaoshijian"
						placeholder="维保时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.weibaoshijian" label="维保时间" prop="weibaoshijian" >
					<el-input v-model="ruleForm.weibaoshijian" placeholder="维保时间" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="textarea" v-if="type!='info'" label="维保详情" prop="weibaoxiangqing" >
				<el-input
					style="min-width: 200px; max-width: 600px;"
					type="textarea"
					:rows="8"
					placeholder="维保详情"
					v-model="ruleForm.weibaoxiangqing" >
				</el-input>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.weibaoxiangqing" label="维保详情" prop="weibaoxiangqing" >
				<span class="text">{{ruleForm.weibaoxiangqing}}</span>
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
					weibaotupian : false,
					zaizhongleixing : false,
					hezaizhongliang : false,
					weibaojindu : false,
					weibaoshijian : false,
					weibaoxiangqing : false,
				},
			
				ruleForm: {
					cheliangmingcheng: '',
					chepaihaoma: '',
					weibaotupian: '',
					zaizhongleixing: '',
					hezaizhongliang: '',
					weibaojindu: '',
					weibaoshijian: '',
					weibaoxiangqing: '',
				},
				weibaojinduOptions: [],

				rules: {
					cheliangmingcheng: [
					],
					chepaihaoma: [
					],
					weibaotupian: [
					],
					zaizhongleixing: [
					],
					hezaizhongliang: [
					],
					weibaojindu: [
					],
					weibaoshijian: [
					],
					weibaoxiangqing: [
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
			this.ruleForm.weibaoshijian = this.getCurDate()
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
						if(o=='weibaotupian'){
							this.ruleForm.weibaotupian = obj[o];
							this.ro.weibaotupian = true;
							continue;
						}
						if(o=='zaizhongleixing'){
							this.ruleForm.zaizhongleixing = obj[o];
							this.ro.zaizhongleixing = true;
							continue;
						}
						if(o=='hezaizhongliang'){
							this.ruleForm.hezaizhongliang = obj[o];
							this.ro.hezaizhongliang = true;
							continue;
						}
						if(o=='weibaojindu'){
							this.ruleForm.weibaojindu = obj[o];
							this.ro.weibaojindu = true;
							continue;
						}
						if(o=='weibaoshijian'){
							this.ruleForm.weibaoshijian = obj[o];
							this.ro.weibaoshijian = true;
							continue;
						}
						if(o=='weibaoxiangqing'){
							this.ruleForm.weibaoxiangqing = obj[o];
							this.ro.weibaoxiangqing = true;
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
				this.weibaojinduOptions = "已完成,进行中".split(',')
			
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `cheliangweibao/info/${id}`,
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
					if(this.ruleForm.weibaotupian!=null) {
						this.ruleForm.weibaotupian = this.ruleForm.weibaotupian.replace(new RegExp(this.$base.url,"g"),"");
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
								url: `cheliangweibao/${!this.ruleForm.id ? "save" : "update"}`,
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
											this.parent.cheliangweibaoCrossAddOrUpdateFlag = false;
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
				this.parent.cheliangweibaoCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			weibaotupianUploadChange(fileUrls) {
				this.ruleForm.weibaotupian = fileUrls;
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
