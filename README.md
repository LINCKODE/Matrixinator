# Matrixinator

Matrixinator is a simple mathematical matrix calculator written in Java 16 that I made to pass math class.

## What can it do?

- Multiply matrix with integer.
- Multiply matrix with another matrix.
- Find out the transpose of matrix.
- Find out determinant of matrix.
- Save the matrices to files for later use.

## Where can you download it?

You can download matrixinator for free from the `Releases` on the right side of this page.

## How do you run it?

Matrixinator needs java 16 to run, so make sure to have it installed.
- Windows: 
	- Press Windows button + R to open the Run.. window.
	- Type `cmd` then press enter to enter the Command Prompt.
	- Navigate to the folder you saved the Matrixinator jar using `cd` and `dir`.
	- To start Matrixinator type `java -jar Matrixinator-X.X.X.jar` replacing the X with the version you downloaded.
- Linux / MacOS:
	- Open a terminal.
	- Navigate to the folder you saved the Matrixinator jar using `cd` and `ls`.
	- To start Matrixinator type `java -jar Matrixinator-X.X.X.jar` replacing the X with the version you downloaded.

## How do you used it?

When starting Matrixinator for the first time, it will inform you that no matrices are loaded.
That is because Matrixinator didn't find any matrix files to load.
Matrixinator will then proceed to ask you to input the name of a new matrix, its size and contents, then it will  display it.
Matrixinator will show you the name of the matrix you just imputed and ask you if you want to create a new matrix or select an already loaded one.
After selecting a matrix you will be asked what do you want to do with it. Your options are:

1. Transpose.
	- Find out what the transpose of the selected matrix is.
2. Determinant.
	- Find out what the determinant of the selected matrix is.
3. Multiply with integer.
	- Multiply the matrix with an integer number.
4. Multiply with Matrix.
	- Multiply the matrix with another one. 
	- **Note that there must be at least 2 loaded matrices to do this.**

5. Save matrix.
	- Save the matrix to a file.
	- *Matrixinator will create a `matrices` folder where the matrices files will be saved with the `.mtx` file extension. The actual file format is `YAML`*
6. Delete Matrix.
	- Delete the matrix from memory and the file containing the matrix if there is one.
