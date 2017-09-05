using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestProject_ConsoleApp
{
	class TestNo003_VarTest
	{
		public void mainFlow()
		{
			var sample1 = 1;
			var sample2 = 2;

			Console.WriteLine("test code 1 : {0}", sample1 + sample2);

			var sample3 = "sample ";
			var sample4 = "code";

			Console.WriteLine("test code 2 : " + sample3 + sample4);
			Console.WriteLine("test code 3 : " + sample3 + sample1);
			Console.ReadKey();
		}
	}
}
