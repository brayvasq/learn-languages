using System;

namespace dotnet
{
    ///<summary>
    /// A child class, representing a Pig. It extends from Animal class
    ///</summary>
    class Pig : Animal {

        ///<summary>
        /// Empty constructor (Parameterless) to set defaults to params
        ///</summary>
        public Pig() : base("") {}

        ///<summary>
        /// Class constructor, setup the specific Pig properties
        ///</summary>
        ///<param name="name">the name of the Pig</param>
        public Pig(string name = "") : base(name){
            base.LimitFood = 2;
            base.LimitWash = 5;
            base.Kind = "pig";
        }

        ///<summary>
        /// Returns the Pig character, depending on the IsAlive() method
        ///</summary>
        ///<returns>
        /// The Pig character
        ///</returns>
        public string GetCharacter(){
            return base.IsAlive() ? "（`（●●）´）" : "（x（●●）x）";
        }

        ///<summary>
        /// Returns the Pig sound
        ///</summary>
        ///<returns>
        /// The Pig sound
        ///</returns>
        public string Speak(){
            return "Oink Oink!!!";
        }
    }
}
