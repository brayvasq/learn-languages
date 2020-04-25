using System;

namespace dotnet
{
    ///<summary>
    /// This is a simple template to define Animals behaviors.
    ///</summary>
    public interface IAnimal
    {
        ///<summary>
        /// Abstract method, it return the animal character. it's implemented in the child classes
        ///</summary>
        ///<returns>
        /// The Animal character
        ///</returns>
        public abstract string GetCharacter();
        ///<summary>
        /// Abstract method, it return the animal sound. it's implemented in the child classes
        ///</summary>
        ///<returns>
        /// The characteristic Animal sound
        ///</returns>
        public abstract string Speak();
        ///<summary>
        /// Abstract method, Gives food to the animal. it's implemented in the child classes
        ///</summary>
        public abstract void Eat();
        ///<summary>
        /// Abstract method, Gives the animal a shower. it's implemented in the child classes
        ///</summary>
        public abstract void Wash();
    }
}
