StringProcess

**Project Overview**
StringProcess is a string conversion project developed based on Java 11 version. Project details:
For a given string that only contains alphabet characters a-z, if 3 or more consecutive
characters are identical, remove them from the string. Repeat this process until
there is no more than 3 identical characters sitting besides each other.
Example:
Input: aabcccbbad
Output: -> aabbbad -> aaad -> d
#Stage 2 - advanced requirement
Instead of removing the consecutively identical characters, replace them with a
single character that comes before it alphabetically.
Example:
ccc -> b
bbb -> a
Input: abcccbad
Output: -> abbbad, ccc is replaced by b -> aaad, bbb is replaced by a -> d

**Project Source Code**
|     |  Backend Source Code  |
|---  |--- |
|  github   |  https://github.com/J2eeFans2020/StringProcessor   |


**Detailed Structure**
```
- src source code
	- main
		- java
			- com.example
				- processor
					- StringProcessor Interface for processing strings with consecutive characters
					- StringProcessorFactory Factory class to create appropriate StringProcessor instances
					- StringRemovalProcessor Processor that removes sequences of 3 or more consecutive identical characters
					- StringReplacementProcessor Processor that replaces sequences of 3 or more consecutive identical characters with the previous character in the alphabet
				- Application Main application class to demonstrate the character processing functionality
	- test Unit testing code
		- java
			- com.example.processor
				- StringProcessorFactoryTest This is the unit test class of the StringProcessorFactory factory class.
				- StringRemovalProcessorTest This is the unit test class of the StringRemovalProcessor class.
				- StringReplacementProcessorTest This is the unit test class of the StringReplacementProcessor class.
- pom.xml 
- README.md 
```