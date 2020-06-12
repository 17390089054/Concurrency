package org.wrf.ForkJoin;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 对静态资源服务器的图片文件目录树进行遍历和分析
 * Copyright © 2019 WRF. All rights reserved.
 * 功能描述：
 * @Package: org.wrf.ForkJoin 
 * @author: knight   
 * @date: 2019年4月22日 上午9:30:31
 */
public class ForkJoinTaskDemo2 {
	public static void main(String[] args) {
		Integer count=new ForkJoinPool().invoke(new CountingTask(Paths.get("E:/Oracle")));
		System.out.println("E:/Oracle下面的文件数量："+count);
		System.out.println("Thread Main End!");
	}
}
//处理单个目录的
class CountingTask extends RecursiveTask<Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Path dir;
	public CountingTask(Path dir) {
		this.dir=dir;
	}
	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		int count=0;
		List<CountingTask> subTasks=new ArrayList<CountingTask>();
		try {
			//读取目录dir的子路径
			DirectoryStream<Path>ds=Files.newDirectoryStream(dir);
			for(Path subPath:ds) {
				if(Files.isDirectory(subPath, LinkOption.NOFOLLOW_LINKS)) {
					//对每个子目录都新建一个子任务
					subTasks.add(new CountingTask(subPath));
				}else {
					//遇到文件，则计数器加1
					count++;
				}
			}
			
			if(!subTasks.isEmpty()) {
				//在当前的ForkJoinPool上调度所有的子任务
				for(CountingTask subTask:invokeAll(subTasks)) {
					count+=subTask.join();
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
}

