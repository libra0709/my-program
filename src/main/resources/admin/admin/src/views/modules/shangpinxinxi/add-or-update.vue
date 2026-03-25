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
				<el-form-item class="input" v-if="type!='info'"  label="商品名称" prop="shangpinmingcheng" >
					<el-input v-model="ruleForm.shangpinmingcheng" placeholder="商品名称" clearable  :readonly="ro.shangpinmingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="商品名称" prop="shangpinmingcheng" >
					<el-input v-model="ruleForm.shangpinmingcheng" placeholder="商品名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="商品分类" prop="shangpinfenlei" >
					<el-select :disabled="ro.shangpinfenlei" v-model="ruleForm.shangpinfenlei" placeholder="请选择商品分类" >
						<el-option
							v-for="(item,index) in shangpinfenleiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="商品分类" prop="shangpinfenlei" >
					<el-input v-model="ruleForm.shangpinfenlei"
						placeholder="商品分类" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.shangpintupian" label="商品图片" prop="shangpintupian" >
					<file-upload
						tip="点击上传商品图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.shangpintupian?ruleForm.shangpintupian:''"
						@change="shangpintupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.shangpintupian" label="商品图片" prop="shangpintupian" >
					<img v-if="ruleForm.shangpintupian.substring(0,4)=='http'&&ruleForm.shangpintupian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.shangpintupian" width="100" height="100">
					<img v-else-if="ruleForm.shangpintupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.shangpintupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.shangpintupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="商品规格" prop="shangpinguige" >
					<el-input v-model="ruleForm.shangpinguige" placeholder="商品规格" clearable  :readonly="ro.shangpinguige"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="商品规格" prop="shangpinguige" >
					<el-input v-model="ruleForm.shangpinguige" placeholder="商品规格" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="库存数量" prop="kucunshuliang" >
					<el-input v-model.number="ruleForm.kucunshuliang" placeholder="库存数量" clearable  :readonly="ro.kucunshuliang"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="库存数量" prop="kucunshuliang" >
					<el-input v-model="ruleForm.kucunshuliang" placeholder="库存数量" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="商品价格" prop="shangpinjiage" >
					<el-input-number v-model="ruleForm.shangpinjiage" placeholder="商品价格" :disabled="ro.shangpinjiage"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="商品价格" prop="shangpinjiage" >
					<el-input v-model="ruleForm.shangpinjiage" placeholder="商品价格" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="生产日期" prop="shengchanriqi" >
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.shengchanriqi" 
						type="date"
						:readonly="ro.shengchanriqi"
						placeholder="生产日期"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.shengchanriqi" label="生产日期" prop="shengchanriqi" >
					<el-input v-model="ruleForm.shengchanriqi" placeholder="生产日期" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="营养成分" prop="yingyangchengfen" >
					<el-input v-model="ruleForm.yingyangchengfen" placeholder="营养成分" clearable  :readonly="ro.yingyangchengfen"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="营养成分" prop="yingyangchengfen" >
					<el-input v-model="ruleForm.yingyangchengfen" placeholder="营养成分" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="商品产地" prop="shangpinchandi" >
					<el-input v-model="ruleForm.shangpinchandi" placeholder="商品产地" clearable  :readonly="ro.shangpinchandi"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="商品产地" prop="shangpinchandi" >
					<el-input v-model="ruleForm.shangpinchandi" placeholder="商品产地" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="上架时间" prop="shangjiashijian" >
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.shangjiashijian" 
						type="date"
						:readonly="ro.shangjiashijian"
						placeholder="上架时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.shangjiashijian" label="上架时间" prop="shangjiashijian" >
					<el-input v-model="ruleForm.shangjiashijian" placeholder="上架时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'" label="储存位置" prop="chucunweizhi" style="display:none">
					<el-select :disabled="ro.chucunweizhi" @change="chucunweizhiChange" v-model="ruleForm.chucunweizhi" placeholder="请选择储存位置">
						<el-option
							v-for="(item,index) in chucunweizhiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.chucunweizhi" label="储存位置" prop="chucunweizhi" style="display:none">
					<el-input v-model="ruleForm.chucunweizhi" placeholder="储存位置" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="仓库名称" prop="cangkumingcheng" style="display:none">
					<el-input v-model="ruleForm.cangkumingcheng" placeholder="仓库名称" clearable  :readonly="ro.cangkumingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="仓库名称" prop="cangkumingcheng" style="display:none">
					<el-input v-model="ruleForm.cangkumingcheng" placeholder="仓库名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="货架号码" prop="huojiahaoma" style="display:none">
					<el-input v-model="ruleForm.huojiahaoma" placeholder="货架号码" clearable  :readonly="ro.huojiahaoma"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="货架号码" prop="huojiahaoma" style="display:none">
					<el-input v-model="ruleForm.huojiahaoma" placeholder="货架号码" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item v-if="type!='info'"  label="商品介绍" prop="shangpinjieshao" >
				<editor 
					style="min-width: 200px; max-width: 600px;"
					v-model="ruleForm.shangpinjieshao" 
					class="editor"
					myQuillEditor="shangpinjieshao"
					action="file/upload">
				</editor>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.shangpinjieshao" label="商品介绍" prop="shangpinjieshao" >
				<span class="text ql-snow ql-editor" v-html="ruleForm.shangpinjieshao"></span>
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
	import { 
		isNumber,
		isIntNumer,
	} from "@/utils/validate";
	export default {
		data() {
			var validateNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isNumber(value)) {
					callback(new Error("请输入数字"));
				} else {
					callback();
				}
			};
			var validateIntNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isIntNumer(value)) {
					callback(new Error("请输入整数"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
				ro:{
					shangpinmingcheng : false,
					shangpinfenlei : false,
					shangpintupian : false,
					shangpinguige : false,
					kucunshuliang : false,
					shangpinjiage : false,
					shengchanriqi : false,
					yingyangchengfen : false,
					shangpinchandi : false,
					shangjiashijian : false,
					shangpinjieshao : false,
					chucunweizhi : false,
					cangkumingcheng : false,
					huojiahaoma : false,
					thumbsupnum : false,
					crazilynum : false,
					clicktime : false,
					clicknum : false,
					discussnum : false,
					storeupnum : false,
				},
			
				ruleForm: {
					shangpinmingcheng: '',
					shangpinfenlei: '',
					shangpintupian: '',
					shangpinguige: '',
					kucunshuliang: '',
					shangpinjiage: '',
					shengchanriqi: '',
					yingyangchengfen: '',
					shangpinchandi: '',
					shangjiashijian: '',
					shangpinjieshao: '',
					chucunweizhi: '',
					cangkumingcheng: '',
					huojiahaoma: '',
					clicktime: '',
				},
				shangpinfenleiOptions: [],
				chucunweizhiOptions: [],

				rules: {
					shangpinmingcheng: [
					],
					shangpinfenlei: [
					],
					shangpintupian: [
					],
					shangpinguige: [
					],
					kucunshuliang: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					shangpinjiage: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					shengchanriqi: [
					],
					yingyangchengfen: [
					],
					shangpinchandi: [
					],
					shangjiashijian: [
					],
					shangpinjieshao: [
					],
					chucunweizhi: [
					],
					cangkumingcheng: [
					],
					huojiahaoma: [
					],
					thumbsupnum: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					crazilynum: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					clicktime: [
					],
					clicknum: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					discussnum: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					storeupnum: [
						{ validator: validateIntNumber, trigger: 'blur' },
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
			this.ruleForm.shangjiashijian = this.getCurDate()
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
						if(o=='shangpinmingcheng'){
							this.ruleForm.shangpinmingcheng = obj[o];
							this.ro.shangpinmingcheng = true;
							continue;
						}
						if(o=='shangpinfenlei'){
							this.ruleForm.shangpinfenlei = obj[o];
							this.ro.shangpinfenlei = true;
							continue;
						}
						if(o=='shangpintupian'){
							this.ruleForm.shangpintupian = obj[o];
							this.ro.shangpintupian = true;
							continue;
						}
						if(o=='shangpinguige'){
							this.ruleForm.shangpinguige = obj[o];
							this.ro.shangpinguige = true;
							continue;
						}
						if(o=='kucunshuliang'){
							this.ruleForm.kucunshuliang = obj[o];
							this.ro.kucunshuliang = true;
							continue;
						}
						if(o=='shangpinjiage'){
							this.ruleForm.shangpinjiage = obj[o];
							this.ro.shangpinjiage = true;
							continue;
						}
						if(o=='shengchanriqi'){
							this.ruleForm.shengchanriqi = obj[o];
							this.ro.shengchanriqi = true;
							continue;
						}
						if(o=='yingyangchengfen'){
							this.ruleForm.yingyangchengfen = obj[o];
							this.ro.yingyangchengfen = true;
							continue;
						}
						if(o=='shangpinchandi'){
							this.ruleForm.shangpinchandi = obj[o];
							this.ro.shangpinchandi = true;
							continue;
						}
						if(o=='shangjiashijian'){
							this.ruleForm.shangjiashijian = obj[o];
							this.ro.shangjiashijian = true;
							continue;
						}
						if(o=='shangpinjieshao'){
							this.ruleForm.shangpinjieshao = obj[o];
							this.ro.shangpinjieshao = true;
							continue;
						}
						if(o=='chucunweizhi'){
							this.ruleForm.chucunweizhi = obj[o];
							this.ro.chucunweizhi = true;
							continue;
						}
						if(o=='cangkumingcheng'){
							this.ruleForm.cangkumingcheng = obj[o];
							this.ro.cangkumingcheng = true;
							continue;
						}
						if(o=='huojiahaoma'){
							this.ruleForm.huojiahaoma = obj[o];
							this.ro.huojiahaoma = true;
							continue;
						}
						if(o=='thumbsupnum'){
							this.ruleForm.thumbsupnum = obj[o];
							this.ro.thumbsupnum = true;
							continue;
						}
						if(o=='crazilynum'){
							this.ruleForm.crazilynum = obj[o];
							this.ro.crazilynum = true;
							continue;
						}
						if(o=='clicktime'){
							this.ruleForm.clicktime = obj[o];
							this.ro.clicktime = true;
							continue;
						}
						if(o=='clicknum'){
							this.ruleForm.clicknum = obj[o];
							this.ro.clicknum = true;
							continue;
						}
						if(o=='discussnum'){
							this.ruleForm.discussnum = obj[o];
							this.ro.discussnum = true;
							continue;
						}
						if(o=='storeupnum'){
							this.ruleForm.storeupnum = obj[o];
							this.ro.storeupnum = true;
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
					} else {
						this.$message.error(data.msg);
					}
				});
				this.$http({
					url: `option/shangpinfenlei/shangpinfenlei`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.shangpinfenleiOptions = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
				this.$http({
					url: `option/cangkuxinxi/cangkuweizhi`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.chucunweizhiOptions = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 下二随
			chucunweizhiChange () {
				this.$http({
					url: `follow/cangkuxinxi/cangkuweizhi?columnValue=`+ this.ruleForm.chucunweizhi,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.cangkumingcheng){
							this.ruleForm.cangkumingcheng = data.data.cangkumingcheng
						}
						if(data.data.huojiahaoma){
							this.ruleForm.huojiahaoma = data.data.huojiahaoma
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `shangpinxinxi/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
						this.ruleForm.shangpinjieshao = this.ruleForm.shangpinjieshao.replace(reg,'../../../springboot6j7op54a/upload');
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.shangpintupian!=null) {
						this.ruleForm.shangpintupian = this.ruleForm.shangpintupian.replace(new RegExp(this.$base.url,"g"),"");
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
								url: `shangpinxinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
											this.parent.shangpinxinxiCrossAddOrUpdateFlag = false;
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
				this.parent.shangpinxinxiCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			shangpintupianUploadChange(fileUrls) {
				this.ruleForm.shangpintupian = fileUrls;
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
