import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import siji from '@/views/modules/siji/list'
	import cheliangweibao from '@/views/modules/cheliangweibao/list'
	import shangpinpandian from '@/views/modules/shangpinpandian/list'
	import shangpinxinxi from '@/views/modules/shangpinxinxi/list'
	import dingdanxinxi from '@/views/modules/dingdanxinxi/list'
	import shangpinruku from '@/views/modules/shangpinruku/list'
	import yunshugenzong from '@/views/modules/yunshugenzong/list'
	import syslog from '@/views/modules/syslog/list'
	import menu from '@/views/modules/menu/list'
	import cangguan from '@/views/modules/cangguan/list'
	import yunshujilu from '@/views/modules/yunshujilu/list'
	import yonghu from '@/views/modules/yonghu/list'
	import shangpinfenlei from '@/views/modules/shangpinfenlei/list'
	import yunshurenwu from '@/views/modules/yunshurenwu/list'
	import discussshangpinxinxi from '@/views/modules/discussshangpinxinxi/list'
	import yichangchuli from '@/views/modules/yichangchuli/list'
	import cheliangdiaodu from '@/views/modules/cheliangdiaodu/list'
	import shangpinchuku from '@/views/modules/shangpinchuku/list'
	import cheliangxinxi from '@/views/modules/cheliangxinxi/list'
	import cangkuxinxi from '@/views/modules/cangkuxinxi/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/siji',
		name: '司机',
		component: siji
	}
	,{
		path: '/cheliangweibao',
		name: '车辆维保',
		component: cheliangweibao
	}
	,{
		path: '/shangpinpandian',
		name: '商品盘点',
		component: shangpinpandian
	}
	,{
		path: '/shangpinxinxi',
		name: '商品信息',
		component: shangpinxinxi
	}
	,{
		path: '/dingdanxinxi',
		name: '订单信息',
		component: dingdanxinxi
	}
	,{
		path: '/shangpinruku',
		name: '商品入库',
		component: shangpinruku
	}
	,{
		path: '/yunshugenzong',
		name: '运输跟踪',
		component: yunshugenzong
	}
	,{
		path: '/syslog',
		name: '系统日志',
		component: syslog
	}
	,{
		path: '/menu',
		name: '菜单列表',
		component: menu
	}
	,{
		path: '/cangguan',
		name: '员工',
		component: cangguan
	}
	,{
		path: '/yunshujilu',
		name: '运输记录',
		component: yunshujilu
	}
	,{
		path: '/yonghu',
		name: '用户',
		component: yonghu
	}
	,{
		path: '/shangpinfenlei',
		name: '商品分类',
		component: shangpinfenlei
	}
	,{
		path: '/yunshurenwu',
		name: '运输任务',
		component: yunshurenwu
	}
	,{
		path: '/discussshangpinxinxi',
		name: '商品信息评论',
		component: discussshangpinxinxi
	}
	,{
		path: '/yichangchuli',
		name: '异常处理',
		component: yichangchuli
	}
	,{
		path: '/cheliangdiaodu',
		name: '车辆调度',
		component: cheliangdiaodu
	}
	,{
		path: '/shangpinchuku',
		name: '商品出库',
		component: shangpinchuku
	}
	,{
		path: '/cheliangxinxi',
		name: '车辆信息',
		component: cheliangxinxi
	}
	,{
		path: '/cangkuxinxi',
		name: '仓库信息',
		component: cangkuxinxi
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
