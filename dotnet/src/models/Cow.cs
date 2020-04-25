using System;

namespace dotnet
{
    ///<summary>
    /// A child class, representing a Cow. It extends from Animal class
    ///</summary>
    class Cow : Animal {

        ///<summary>
        /// Empty constructor (Parameterless) to set defaults to params
        ///</summary>
        public Cow() : base("") {}

        ///<summary>
        /// Class constructor, setup the specific Cow properties
        ///</summary>
        ///<param name="name">the name of the Cow</param>
        public Cow(string name = "") : base(name){
            base.LimitFood = 3;
            base.LimitWash = 10;
            base.Kind = "cow";
        }

        ///<summary>
        /// Returns the Cow character, depending on the IsAlive() method
        ///</summary>
        ///<returns>
        /// The Cow character
        ///</returns>
        public string GetCharacter(){
            string character = "  (....)  \n";
            character += base.IsAlive() ? "（0 .. 0）" : "（X .. X）";
            return character;
        }

        ///<summary>
        /// Returns the Cow sound
        ///</summary>
        ///<returns>
        /// The Cow sound
        ///</returns>
        public string Speak() => "Muuu Muuu!!!";
    }
}
