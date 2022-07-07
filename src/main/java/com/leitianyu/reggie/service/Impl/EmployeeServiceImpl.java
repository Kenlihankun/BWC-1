package com.leitianyu.reggie.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leitianyu.reggie.entity.Employee;
import com.leitianyu.reggie.mapper.EmployeeMapper;
import com.leitianyu.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {



}
