

$(function(){

})


//显示编辑User窗口
function showEditUser(userId,type){
layer.open({
    type: 2,
    title: '编辑用户信息',
    area: ['500px', '400px'],
    fix: false, //不固定
    maxmin: true,
    content: '/UrpAction/showUserMsg?userId='+userId+"&type="+type
});
}

//显示编辑Role窗口
function showEditRole(roleId,type){
layer.open({
    type: 2,
    title: '编辑用户信息',
    area: ['500px', '400px'],
    fix: false, //不固定
    maxmin: true,
    content: '/UrpAction/showRoleMsg?roleId='+roleId+"&type="+type
});
}

//显示编辑Permission窗口
function showEditPermission(permissionId,type){
layer.open({
    type: 2,
    title: '编辑用户信息',
    area: ['500px', '400px'],
    fix: false, //不固定
    maxmin: true,
    content: '/UrpAction/showPermissionMsg?permissionId='+permissionId+"&type="+type
});
}

//显示编辑Resource窗口
function showEditResource(resourceId,type){
layer.open({
    type: 2,
    title: '编辑用户信息',
    area: ['500px', '550px'],
    fix: false, //不固定
    maxmin: true,
    content: '/UrpAction/showResourceMsg?resourceId='+resourceId+"&type="+type
});
}


//显示UserRole窗口
function showUserRole(userId){
layer.open({
    type: 2,
    title: '用户拥有的角色',
    area: ['700px', '530px'],
    fix: false, //不固定
    maxmin: true,
    content: '/UrpAction/showUserRole?userId='+userId+"&type=has"
});
}

//显示UserRole窗口
function showUserBindRole(userId){
layer.open({
    type: 2,
    title: '新增角色',
    area: ['700px', '530px'],
    fix: false, //不固定
    maxmin: true,
    content: '/UrpAction/showUserRole?userId='+userId+"&type=add"
});
}

//显示RolePermission窗口
function showRolePermission(roleId){
layer.open({
    type: 2,
    title: '用户拥有的角色',
    area: ['700px', '530px'],
    fix: false, //不固定
    maxmin: true,
    content: '/UrpAction/showRolePermission?roleId='+roleId+"&type=has"
});
}

//显示RolePermission窗口
function showRoleBindPermission(roleId){
layer.open({
    type: 2,
    title: '用户拥有的角色',
    area: ['700px', '530px'],
    fix: false, //不固定
    maxmin: true,
    content: '/UrpAction/showRolePermission?roleId='+roleId+"&type=add"
});
}

//显示PermissionResource窗口
function showPermissionResource(permissionId){
layer.open({
    type: 2,
    title: '用户拥有的角色',
    area: ['700px', '530px'],
    fix: false, //不固定
    maxmin: true,
    content: '/UrpAction/showPermissionResource?permissionId='+permissionId+"&type=has"
});
}

//显示PermissionResource窗口
function showPermissionBindResource(permissionId){
layer.open({
    type: 2,
    title: '用户拥有的角色',
    area: ['700px', '530px'],
    fix: false, //不固定
    maxmin: true,
    content: '/UrpAction/showPermissionResource?permissionId='+permissionId+"&type=add"
});
}

//新增User
function addUser(){
    $.ajax({
    		type:"POST",
    		url : "/UrpAction/addUser",
    		data:{
    		    username:$("#username").val(),
    		    password:$("#password").val(),
    		    available:$("#available").val(),
    		    remark:$("#remark").val()
    		},
    		dataType : "json",
    		success:function(ret){
            layer.msg('新用户创建成功', {
                    time : 700,
                    offset : '20%'
            });
            window.parent.location.reload();
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
    		},
    		error:function(){
                layer.msg('连接失败', {
                    time : 700,
                    offset : '20%'
                });
    		}
    });
}

function addRole(){
if($("#name").val() == "" ||$("#description").val() == ""){
    layer.msg('不能为空', {
        time : 700,
        offset : '20%'
    });
    return ;
}

//新增角色
$.ajax({
		type:"POST",
		url : "/UrpAction/addRole",
		data:{
		    name:$("#name").val(),
		    description:$("#description").val(),
		    available:$("#available").val(),
		    remark:$("#remark").val()
		},
		dataType : "json",
		success:function(ret){
		    if(ret == "1"){
		        layer.msg('角色已存在', {
                    time : 700,
                    offset : '20%'
                });
                return ;
		    }
            layer.msg('角色新增成功', {
                time : 700,
                offset : '20%'
            });
            window.parent.location.reload();
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
		},
		error:function(){
			layer.msg('连接失败', {
                time : 700,
                offset : '20%'
            });
		}
});

}

function addPermission(){
if($("#permission").val() == "" ||$("#description").val() == ""){
    layer.msg('不能为空', {
        time : 700,
        offset : '20%'
    });
    return ;
}

//新增权限
$.ajax({
		type:"POST",
		url : "/UrpAction/addPermission",
		data:{
		    permission:$("#permission").val(),
		    description:$("#description").val(),
            available:$("#available").val(),
            remark:$("#remark").val()
		},
		dataType : "json",
		success:function(ret){
		    if(ret == "1"){
                layer.msg('权限已存在', {
                    time : 700,
                    offset : '20%'
                });
                return ;
            }
            layer.msg('权限新增成功', {
                time : 700,
                offset : '20%'
            });
            window.parent.location.reload();
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
		},
		error:function(){
			layer.msg('连接失败', {
                time : 700,
                offset : '20%'
            });
		}
});

}

function addResource(){
if($("#url").val() == ""){
    layer.msg('url不能为空', {
        time : 700,
        offset : '20%'
    });
    return ;
}

//新增权限
$.ajax({
		type:"POST",
		url : "/UrpAction/addResource",
		data:{
		    name:$("#name").val(),
		    url:$("#url").val(),
		    type:$("#type").val(),
		    priority:$("#priority").val(),
		    parentId:$("#parentId").val(),
		    available:$("#available").val(),
            remark:$("#remark").val()
		},
		dataType : "json",
		success:function(ret){
		    if(ret == "1"){
                layer.msg('资源已存在', {
                    time : 700,
                    offset : '20%'
                });
                return ;
            }
            layer.msg('资源新增成功', {
                time : 700,
                offset : '20%'
            });
            window.parent.location.reload();
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
		},
		error:function(){
			layer.msg('连接失败', {
                time : 700,
                offset : '20%'
            });
		}
});

}


function editUser(userId){

$.ajax({
		type:"POST",
		url : "/UrpAction/modifyUser",
		data:{
		    id:userId,
		    username:$("#username").val(),
		    password:$("#password").val(),
		    available:$("#available").val(),
		    remark:$("#remark").val()
		},
		dataType : "json",
		success:function(ret){
		    layer.msg('修改成功', {
                            time : 700,
                            offset : '20%'
            });
            window.parent.location.reload();
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);

		},
		error:function(){
            layer.msg('连接失败', {
                time : 700,
                offset : '20%'
            });
		}
});

}


function editRole(roleId){

$.ajax({
		type:"POST",
		url : "/UrpAction/modifyRole",
		data:{
		    id:roleId,
		    name:$("#name").val(),
		    description:$("#description").val(),
		    available:$("#available").val(),
		    remark:$("#remark").val()
		},
		dataType : "json",
		success:function(ret){
		    layer.msg('修改成功', {
                time : 700,
                offset : '20%'
            });
            window.parent.location.reload();
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);

		},
		error:function(){
            layer.msg('连接失败', {
                time : 700,
                offset : '20%'
            });
		}
});

}

function editPermission(permissionId){

$.ajax({
		type:"POST",
		url : "/UrpAction/modifyPermission",
		data:{
		    id:permissionId,
		    permission:$("#permission").val(),
		    description:$("#description").val(),
		    available:$("#available").val(),
		    remark:$("#remark").val()
		},
		dataType : "json",
		success:function(ret){
		    layer.msg('修改成功', {
                time : 700,
                offset : '20%'
            });
            window.parent.location.reload();
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);

		},
		error:function(){
            layer.msg('连接失败', {
                time : 700,
                offset : '20%'
            });
		}
});

}



function editResource(resourceId){

$.ajax({
		type:"POST",
		url : "/UrpAction/modifyResource",
		data:{
		    id:resourceId,
		    name:$("#name").val(),
		    url:$("#url").val(),
		    type:$("#type").val(),
		    priority:$("#priority").val(),
		    parentId:$("#parentId").val(),
		    available:$("#available").val(),
		    remark:$("#remark").val()
		},
		dataType : "json",
		success:function(ret){
		    layer.msg('修改成功', {
                time : 700,
                offset : '20%'
            });
            window.parent.location.reload();
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);

		},
		error:function(){
            layer.msg('连接失败', {
                time : 700,
                offset : '20%'
            });
		}
});

}

function deleteUsers(){
    if($('input[name="user"]:checked').length == 0){
    layer.msg('请选择', {
        time : 700,
        offset : '20%'
    });
    return ;
    }
    $('input[name="user"]:checked').each(
        function() {
            var id = $(this).val();
            deleteUser(id);
    });
}

function deleteUser(userId){
    $.ajax({
            type:"POST",
            url : "/UrpAction/deleteUser",
            data:{
                id:userId
            },
            dataType : "json",
            success:function(ret){
                layer.msg('删除成功', {
                    time : 700,
                    offset : '20%'
                });
                setTimeout(function() {
                    location.reload();
                }, 800);
            },
            error:function(){
                layer.msg('连接失败', {
                    time : 700,
                    offset : '20%'
                });
            }
    });
}

function deleteRoles(){
    if($('input[name="role"]:checked').length == 0){
    layer.msg('请选择', {
        time : 700,
        offset : '20%'
    });
    return ;
    }
    $('input[name="role"]:checked').each(
        function() {
            var id = $(this).val();
            deleteRole(id);
        });
}

function deleteRole(roleId){
    $.ajax({
    		type:"POST",
    		url : "/UrpAction/deleteRole",
    		data:{
    		    id:roleId
    		},
    		dataType : "json",
    		success:function(ret){
                layer.msg('删除成功', {
                    time : 700,
                    offset : '20%'
                });
                setTimeout(function() {
                    location.reload();
                }, 800);
    		},
    		error:function(){
                layer.msg('连接失败', {
                    time : 700,
                    offset : '20%'
                });
    		}
    });
}

function deletePermissions(){
    if($('input[name="permission"]:checked').length == 0){
    layer.msg('请选择', {
        time : 700,
        offset : '20%'
    });
    return ;
    }
    $('input[name="permission"]:checked').each(
        function() {
            var id = $(this).val();
            deletePermission(id);
    });
}

function deletePermission(permissionId){
    $.ajax({
    		type:"POST",
    		url : "/UrpAction/deletePermission",
    		data:{
    		    id:permissionId
    		},
    		dataType : "json",
    		success:function(ret){
                layer.msg('删除成功', {
                    time : 700,
                    offset : '20%'
                });
                setTimeout(function() {
                    location.reload();
                }, 800);
    		},
    		error:function(){
                layer.msg('连接失败', {
                    time : 700,
                    offset : '20%'
                });
    		}
    });

}


function deleteResources(){
    if($('input[name="resource"]:checked').length == 0){
    layer.msg('请选择', {
        time : 700,
        offset : '20%'
    });
    return ;
    }
    $('input[name="resource"]:checked').each(
        function() {
            var id = $(this).val();
            deleteResource(id);
    });
}


function deleteResource(resourceId){
    $.ajax({
    		type:"POST",
    		url : "/UrpAction/deleteResource",
    		data:{
    		    id:resourceId
    		},
    		dataType : "json",
    		success:function(ret){
                layer.msg('删除成功', {
                    time : 700,
                    offset : '20%'
                });
                setTimeout(function() {
                    location.reload();
                }, 800);
    		},
    		error:function(){
                layer.msg('连接失败', {
                    time : 700,
                    offset : '20%'
                });
    		}
    });
}

//关联User和Role
function userBindRole(userId){
    $('input[name="role"]:checked').each(
        function() {
            var id = $(this).val();
            $.ajax({
                    type:"POST",
                    url : "/UrpAction/UserBindRole",
                    data:{
                        userId:userId,
                        id:id
                    },
                    dataType : "json",
                    success:function(ret){
                            if(ret == "1"){
                                layer.msg('失败', {
                                    time : 700,
                                    offset : '20%'
                                });
                                return ;
                            }
                            layer.msg('角色赋予成功', {
                                time : 700,
                                offset : '20%'
                            });
                            setTimeout(function() {
                                var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                                parent.layer.close(index);
                            }, 800);

                    },
                    error:function(){
                        layer.msg('连接失败', {
                            time : 700,
                            offset : '20%'
                        });
                    }
            });

        }
    );
}

//关联Role和Permission
function roleBindPermission(roleId){
    $('input[name="permission"]:checked').each(
        function() {
            var id = $(this).val();
            $.ajax({
                    type:"POST",
                    url : "/UrpAction/RoleBindPermission",
                    data:{
                        roleId:roleId,
                        id:id
                    },
                    dataType : "json",
                    success:function(ret){
                            if(ret == "1"){
                                layer.msg('失败', {
                                    time : 700,
                                    offset : '20%'
                                });
                                return ;
                            }
                            layer.msg('角色赋予成功', {
                                time : 700,
                                offset : '20%'
                            });
                            setTimeout(function() {
                                var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                                parent.layer.close(index);
                            }, 800);
                    },
                    error:function(){
                        layer.msg('连接失败', {
                            time : 700,
                            offset : '20%'
                        });
                    }
            });

        }
    );
}


//关联Permission和Resource
function PermissionBindResource(permissionId){
    $('input[name="resource"]:checked').each(
        function() {
            var id = $(this).val();
            $.ajax({
                    type:"POST",
                    url : "/UrpAction/PermissionBindResource",
                    data:{
                        permissionId:permissionId,
                        id:id
                    },
                    dataType : "json",
                    success:function(ret){
                            if(ret == "1"){
                                layer.msg('失败', {
                                    time : 700,
                                    offset : '20%'
                                });
                                return ;
                            }
                            layer.msg('角色赋予成功', {
                                time : 700,
                                offset : '20%'
                            });
                            setTimeout(function() {
                                var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                                parent.layer.close(index);
                            }, 800);
                    },
                    error:function(){
                        layer.msg('连接失败', {
                            time : 700,
                            offset : '20%'
                        });
                    }
            });

        }
    );
}



//删除User与Role的关联
function deleteUserBindRole(userId){
    if($('input[name="role"]:checked').length == 0){
    layer.msg('请选择', {
        time : 700,
        offset : '20%'
    });
    return ;
    }

    $('input[name="role"]:checked').each(
        function() {
            var id = $(this).val();
            $.ajax({
                    type:"POST",
                    url : "/UrpAction/UserUnBindRole",
                    data:{
                        userId:userId,
                        id:id
                    },
                    dataType : "json",
                    success:function(ret){
                        layer.msg('删除成功', {
                            time : 700,
                            offset : '20%'
                        });
                        setTimeout(function() {
                            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                            parent.layer.close(index);
                        }, 800);
                    },
                    error:function(){
                        layer.msg('连接失败', {
                            time : 700,
                            offset : '20%'
                        });
                    }
            });
        }
    );
}

//删除Role与Permission的关联
function deleteRoleBindPermission(roleId){
    if($('input[name="permission"]:checked').length == 0){
    layer.msg('请选择', {
        time : 700,
        offset : '20%'
    });
    return ;
    }

    $('input[name="permission"]:checked').each(
        function() {
            var id = $(this).val();
            $.ajax({
                    type:"POST",
                    url : "/UrpAction/RoleUnBindPermission",
                    data:{
                        roleId:roleId,
                        id:id
                    },
                    dataType : "json",
                    success:function(ret){
                        layer.msg('删除成功', {
                            time : 700,
                            offset : '20%'
                        });
                        setTimeout(function() {
                            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                            parent.layer.close(index);
                        }, 800);
                    },
                    error:function(){
                        layer.msg('连接失败', {
                            time : 700,
                            offset : '20%'
                        });
                    }
            });
        }
    );
}

//删除Permission与Resource的关联
function deletePermissionBindResource(permissionId){
    if($('input[name="resource"]:checked').length == 0){
    layer.msg('请选择', {
        time : 700,
        offset : '20%'
    });
    return ;
    }

    $('input[name="resource"]:checked').each(
        function() {
            var id = $(this).val();
            $.ajax({
                    type:"POST",
                    url : "/UrpAction/PermissionUnBindResource",
                    data:{
                        id:id
                    },
                    dataType : "json",
                    success:function(ret){
                        layer.msg('删除成功', {
                            time : 700,
                            offset : '20%'
                        });
                        setTimeout(function() {
                            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                            parent.layer.close(index);
                        }, 800);
                    },
                    error:function(){
                        layer.msg('连接失败', {
                            time : 700,
                            offset : '20%'
                        });
                    }
            });
        }
    );
}

//=================================================================
//=================================================================
//=================================================================


function searchUser(){
$.ajax({
    type:"POST",
    url : "/UrpAction/searchUser",
    data:{
        userName:$("#searchInput").val()
    },
    dataType : "json",
    success:function(ret){
        $(".flash").remove();
        var str = "";
        for(var i = 0 ; i < ret.length;i++){

        str += '<tr id="'+ret[i].id+'">'+
               '<td><input type="checkbox" name="user" value="'+ret[i].id+'" /></td>'+
               '<td>'+ret[i].username+'</td>'+
               '<td>'+ret[i].available+'</td>'+
               '<td>'+(ret[i].remark == undefined?"":ret[i].remark)+'</td>'+
               '<td>'+
               '<button type="button" class="btn btn-primary btn-xs" onclick="showEditUser(\''+ret[i].id+'\',1)">编辑</button>'+
               '<button type="button" class="btn btn-primary btn-xs" onclick="deleteUser(\''+ret[i].id+'\')">删除</button>'+
               '<button type="button" class="btn btn-primary btn-xs" onclick="showUserRole(\''+ret[i].id+'\')">已有角色</button>'+
               '<button type="button" class="btn btn-primary btn-xs" onclick="showUserBindRole(\''+ret[i].id+'\')">新增角色</button>'+
               '</td>'+
               '</tr>';
        }
        $(".table").append(str);
    },
    error:function(){
        layer.msg('连接失败', {
            time : 700,
            offset : '20%'
        });
    }
});
}

function searchRole(type){
$.ajax({
    type:"POST",
    url : "/UrpAction/searchRole",
    data:{
        roleName:$("#searchInput").val()
    },
    dataType : "json",
    success:function(ret){
        $(".flash").remove();
        var str = "";
        for(var i = 0 ; i < ret.length;i++){
        str += '<tr id="'+ret[i].id+'" class="flash">'+
               '<td><input type="checkbox" name="role" value="'+ret[i].id+'" /></td>'+
               '<td>'+ret[i].name+'</td>'+
               '<td>'+ret[i].description+'</td>'+
               '<td>'+ret[i].available+'</td>'+
               '<td>'+(ret[i].remark == undefined?"":ret[i].remark)+'</td>'+
               (type == 1?'<td>'+
                 '<button type="button" class="btn btn-primary btn-xs" onclick="showEditRole(\''+ret[i].id+'\',1)">编辑</button>'+
                 '<button type="button" class="btn btn-primary btn-xs" onclick="deleteRole(\''+ret[i].id+'\')">删除</button>'+
                 '<button type="button" class="btn btn-primary btn-xs" onclick="showRolePermission(\''+ret[i].id+'\')">已有权限</button>'+
                 '<button type="button" class="btn btn-primary btn-xs" onclick="showRoleBindPermission(\''+ret[i].id+'\')">新增权限</button>'+
                 '</td>':"")+
               '</tr>';
        }
        $(".table").append(str);
    },
    error:function(){
        layer.msg('连接失败', {
            time : 700,
            offset : '20%'
        });
    }
});
}

function searchPermission(type){
$.ajax({
    type:"POST",
    url : "/UrpAction/searchPermission",
    data:{
        permissionName:$("#searchInput").val()
    },
    dataType : "json",
    success:function(ret){
        $(".flash").remove();
        var str = "";
        for(var i = 0 ; i < ret.length;i++){
        str += '<tr id="'+ret[i].id+'" class="flash">'+
               '<td><input type="checkbox" name="permission" value="'+ret[i].id+'" /></td>'+
               '<td>'+ret[i].permission+'</td>'+
               '<td>'+ret[i].description+'</td>'+
               '<td>'+ret[i].available+'</td>'+
               '<td>'+(ret[i].remark == undefined?"":ret[i].remark)+'</td>'+
               (type == 1?'<td>'+
                 '<button type="button" class="btn btn-primary btn-xs" onclick="showEditPermission(\''+ret[i].id+'\',1)">编辑</button>'+
                 '<button type="button" class="btn btn-primary btn-xs" onclick="deletePermission(\''+ret[i].id+'\')">删除</button>'+
                 '<button type="button" class="btn btn-primary btn-xs" onclick="showPermissionResource(\''+ret[i].id+'\')">已有资源</button>'+
                 '<button type="button" class="btn btn-primary btn-xs" onclick="showPermissionBindResource(\''+ret[i].id+'\')">新增资源</button>'+
                 '</td>':"")+
               '</tr>';
        }
        $(".table").append(str);
    },
    error:function(){
        layer.msg('连接失败', {
            time : 700,
            offset : '20%'
        });
    }
});
}

function searchResource(type){
$.ajax({
    type:"POST",
    url : "/UrpAction/searchResource",
    data:{
        resourceName:$("#searchInput").val()
    },
    dataType : "json",
    success:function(ret){
        $(".flash").remove();
        var str = "";
        for(var i = 0 ; i < ret.length;i++){
        str += '<tr id="'+ret[i].id+'" class="flash">'+
               '<td><input type="checkbox" name="resource" value="'+ret[i].id+'" /></td>'+
               '<td>'+ret[i].name+'</td>'+
               '<td>'+ret[i].type+'</td>'+
               '<td>'+ret[i].url+'</td>'+
               '<td>'+ret[i].available+'</td>'+
               '<td>'+ret[i].priority+'</td>'+
               '<td>'+ret[i].parentId+'</td>'+
               '<td>'+(ret[i].remark == undefined?"":ret[i].remark)+'</td>'+
               (type == 1?'<td>'+
                 '<button type="button" class="btn btn-primary btn-xs" onclick="showEditResource(\''+ret[i].id+'\',1)">编辑</button>'+
                 '<button type="button" class="btn btn-primary btn-xs" onclick="deleteResource(\''+ret[i].id+'\')">删除</button>'+
                 '</td>':"")+
               '</tr>';
        }
        $(".table").append(str);
    },
    error:function(){
        layer.msg('连接失败', {
            time : 700,
            offset : '20%'
        });
    }
});
}