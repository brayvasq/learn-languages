using System;

namespace dotnet
{
    ///<summary>
    /// Main file. It will executes the app
    /// Author: brayvasq <brayvasq@gmail.com>
    /// Version: 0.2
    ///</summary>
    class Program
    {
        static void Main(string[] args)
        {
            new Commands(args).Process();
        }
    }
}
