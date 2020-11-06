package aspects;

import java.io.FileWriter;
import java.io.IOException;

public aspect StorageAspect {
	pointcut mehtodLogger(): call(void com.Lab2.StorageService.*(..));
	
	void around(): mehtodLogger()
	{
		try(FileWriter fw = new FileWriter("method_story.txt",true))
		{
			Long start = System.currentTimeMillis();
			proceed();
			Long total = System.currentTimeMillis()-start;
			fw.write(total.toString()+"ms"+" "+thisJoinPointStaticPart.getSignature().getName()+"\n");
		}
		catch(IOException ex)
		{
			proceed();
			System.out.println("Can't open log file");
		}
		
	}
}
