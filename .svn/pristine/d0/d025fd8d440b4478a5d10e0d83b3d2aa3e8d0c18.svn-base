package com.oracle.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.oracle.dto.QaMapDto;
import com.oracle.entity.Users;

public class UsersAction extends ActionSupport /*implements ModelDriven<Users>*/{
	/*
	private String t;
	//reuqest.getParamater()
	public void setT(String t){
		this.t=t;
	}
	//request.setAttribute()
	public String getT(){
		return t;
	}
	
	
	//主方法
	public String execute() throws Exception {
		//struts中获取request对象
		//HttpServletRequest request = ServletActionContext.getRequest();
		
		//String t=request.getParameter("t");
		
		System.out.println("UsersAction.execute!!!");
		if("1".equals(t)){
			//返回成功
			return "success";
		}else {
			//返回失败
			return "abcd";
		}
		//return super.execute();
	}
	*/
	
	
	
	/*
	//属性驱动
	private Integer id;
	private String name;
	private String username;
	private String password;
	private int age;//struts可以自动收取参数并转换为需要的类型
	private String tel;
	 */
	
	
	/*
	//域属性驱动
	private List<Users> list;
	private Users users;
	*/
	/*
	 * 当前端页面表单不能使用域属性传输参数时,可以使用模型驱动来创建并自动参数化对象模型
	 * */
	//模型驱动,需要先实现ModelDriven接口
	Users users = null;
	
	public Users getModel() {
		if(users==null){
			users=new Users();
		}
		return users;
	}
	
	
	/*
	 * struts可以自动获取数组集合
	 * 但如果页面使用表单提交数组元素,则必须通过多个文本框等
	 * 
	 * 或者通过超链接(url),将多个值使用同一个key提交
	 * struts可以自动将数据转换为定义的数据类型
	 * 
	 * */
	private String ids;
	private String[] ids1;
	private int[] ids2;
	
	
	//使用modelDriven后,无法在单独获取modelDriven模型内部的属性值
	//比如使用modelDriven管理Users对象的参数
	//则无法单独收取Users对象中的任意参数值
	
	//如果参数类型无法转换,或int类型初始值为null都会出现result input的错误
	private Integer id;
	private String name;
	
	
	public String addPage(){
		System.out.println("UserAction.addPage...........");
		
		return "success";
	}
	
	public String add(){
		System.out.println("UserAction.add...........");
		
		//users=new Users(name, username, password, age, tel);
		
		//通过调用模型驱动方法,获取封装好的模型
		
		System.out.println(users);
		
		
		return "success";
	}
	
	public String list(){
		System.out.println("UserAction.list...........");
		return SUCCESS;
	}
	
	public String updatePage(){
		System.out.println("UserAction.updatePage...........");
		return SUCCESS;
	}
	
	
	private String[] question;
	private String[] answer;
	
	/*
	 * 按照指定顺序接收参数,在多值存在映射关系时,可以有效保证映射关系的顺序性
	 * */
	private List<String> ques;
	private List<String> answ;
	
	
	
	private Map<String, Object> map;
	private List<Map<String, Object>> list;
	
	
	private List<QaMapDto> list1;
	public String update(){
		System.out.println("UserAction.update...........");
		
		/*for (String string : question) {
			System.out.println(string);
		}
		
		for (String string : answer) {
			System.out.println(string);
		}*/
		
		/*for(int i=0;i<question.length;i++){
			System.out.println(question[i]);
			System.out.println(answer[i]);
		}*/
		
		
		/*
		for(int i=0;i<ques.size();i++){
			System.out.println(ques.get(i));
			System.out.println(answ.get(i));
		}*/
		
		map.get("key1");//class [Ljava.lang.String;
		
		String[] temp=(String[])map.get("key1");
		
		for (String string : temp) {
			System.out.println(string);
		}
		System.out.println("////////////");
		System.out.println(map.get("key2").toString());
		System.out.println(map.get("key3").toString());
		
		return SUCCESS;
	}
	
	
	
	public String delete(){
		System.out.println("UserAction.delete...........");
		//System.out.println(ids);
		/*
		ids1=1,2,3,4
		ids1=1&ids1=2&ids1=3
		ids1=1%26ids1%3D2%26ids%3D3
		System.out.println(ids1);//1,2,3,4
		//System.out.println(ids1.length);
		
		System.out.println(ids2);
		System.out.println(ids2.length);
		
		*/
		
		System.out.println(id);
		//System.out.println(name);
		
		
		
		return SUCCESS;
	}
	/*
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	 */
	/*public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}*/

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String[] getIds1() {
		return ids1;
	}

	public void setIds1(String[] ids1) {
		this.ids1 = ids1;
	}

	public int[] getIds2() {
		return ids2;
	}

	public void setIds2(int[] ids2) {
		this.ids2 = ids2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getQuestion() {
		return question;
	}

	public void setQuestion(String[] question) {
		this.question = question;
	}

	public String[] getAnswer() {
		return answer;
	}

	public void setAnswer(String[] answer) {
		this.answer = answer;
	}

	public List<String> getQues() {
		return ques;
	}

	public void setQues(List<String> ques) {
		this.ques = ques;
	}

	public List<String> getAnsw() {
		return answ;
	}

	public void setAnsw(List<String> answ) {
		this.answ = answ;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}
	
	
}

