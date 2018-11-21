<html>

	<head>
		<meta charset="utf-8" />
		<title></title>
	</head>

	<body>

		<tr>
			<td>
				<select name="shengji" style="width: 145px" id="shengji">
					<option value="-1">省、自治区、直辖市</option>
					<option value="浙江省(浙)">浙江省(浙)</option>
					<option value="江苏省(苏)">江苏省(苏)</option>
				</select>
			</td>
			<td>
				<select name="diji" style="width: 175px">
					<option value="-1">地级市、地区、自治州、盟</option>
				</select>
			</td>
			<td>
				<select name="xianji" style="width: 155px">
					<option value="-1">市辖区、县级市、县…</option>
				</select>
			</td>
	</body>
	<script type="text/javascript" src="../../js/jquery-1.9.1.min.js"></script>
	
	<script>
		$(function() {
			$("#shengji").click(function() {
				;
				$.ajax({
					type:"post",
					url:"http://xzqh.mca.gov.cn/selectJson",
					data:{shengji:$("#shengji").val()},
					dataType: "json",
					success: function(data){
						alert("1");
					}
				})
			})

		});
	</script>

</html>