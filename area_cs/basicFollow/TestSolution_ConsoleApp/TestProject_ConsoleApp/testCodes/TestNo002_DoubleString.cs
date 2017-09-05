using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestProject_ConsoleApp
{
	class TestNo002_DoubleString
	{
		public void mainFlow()
		{
			// 두 문자열을 합친 후에, 합친 문자열과 다섯번째 문자를 출력해 보자.
			string str1 = "firstString";
			string str2 = "secondString";

			string result1 = str1 + str2;
			string result2 = result1.Substring(4, 1);	// (4)번째 글자부터 오른쪽 방향으로 (1)개의 글자를 출력.
			Console.WriteLine("result 1 : " + result1);
			Console.WriteLine("result 2 : " + result2);
			Console.WriteLine("fixed result2 : " + result1[4] + "\n");

			int strNum = result1.Length;
			Console.WriteLine("result3 : " + strNum);
			Console.WriteLine("fixed result3 : {0}", strNum);
			
			Console.ReadKey();
		}
		
		
	}
}
