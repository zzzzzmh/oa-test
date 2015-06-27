<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<%@ include file="../common/header.jsp"%>
<div id="main" class="container-fluid">
	<div class="row">
		<%@ include file="../common/left.jsp"%>
		<div id="content" class="col-xs-12 col-sm-10">
			<div id="ajax-content">
				<div class="row">
				<div class="col-xs-12 col-sm-12">
					<div class="box">
						<div class="box-header">
							<div class="box-name">
								<i class="fa fa-search"></i>
								<span>商品添加</span>
							</div>
						</div>
						<div class="box-content">
							<form id="defaultForm" method="post" action="<c:url value='/cms/goods/addsub'/>" class="form-horizontal">
								<fieldset>
									<legend>Not Empty validator</legend>
									<div class="form-group">
										<label class="col-sm-3 control-label">title</label>
										<div class="col-sm-5">
											<input type="text" class="form-control" name="title" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">product</label>
										<div class="col-sm-5">
											<input type="text" class="form-control" name="product" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">category</label>
										<div class="col-sm-5">
											<select multiple="" class="form-control" name="category">
												<option value="2">php开发</option>
												<option value="3">java开发</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">price</label>
										<div class="col-sm-3">
											<input type="text" class="form-control" name="price" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">cost price</label>
										<div class="col-sm-3">
											<input type="text" class="form-control" name="costPrice" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">desc</label>
										<div class="col-sm-5">
											<textarea name="desc.description" class="form-control" rows="10" cols="17"></textarea>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-9 col-sm-offset-3">
											<div class="checkbox">
												<label>
													<input type="checkbox"  name="status" /> 是否有效
													<i class="fa fa-square-o small"></i>
												</label>
											</div>
										</div>
									</div>
								</fieldset>
								
								<div class="form-group">
									<div class="col-sm-9 col-sm-offset-3">
										<input type="hidden" name="spId" value="0" />
										<button type="submit" class="btn btn-primary">Submit</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
				<script type="text/javascript">
				// Run Select2 plugin on elements
				function DemoSelect2(){
					$('#s2_with_tag').select2({placeholder: "Select OS"});
					$('#s2_country').select2();
				}
				// Run timepicker
				function DemoTimePicker(){
					$('#input_time').timepicker({setDate: new Date()});
				}
				$(document).ready(function() {
					// Add slider for change test input length
					FormLayoutExampleInputLength($( ".slider-style" ));
					// Initialize datepicker
					$('#input_date').datepicker({setDate: new Date()});
					// Load Timepicker plugin
					LoadTimePickerScript(DemoTimePicker);
					// Add tooltip to form-controls
					$('.form-control').tooltip();
					LoadSelect2Script(DemoSelect2);
					// Load example of form validation
					LoadBootstrapValidatorScript(DemoFormValidator);
					// Add drag-n-drop feature to boxes
					WinMove();
				});
				</script>
	
			</div>
		</div>
	</div>
</div>
<%@ include file="../common/footer.jsp"%>