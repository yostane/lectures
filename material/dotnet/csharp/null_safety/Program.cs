bool CanReadFile(string path)
{
    if (path == "fail.txt")
    {
        return false;
    }
    return true;
}

string GetFileContents(string path)
{
    return "Contenu fictif d'un fichier";
}

string ReadFromFile(string path)
{
    if (CanReadFile(path))
    {
        return GetFileContents(path);
    }
    else
    {
        return null;
    }
}

string s1 = ReadFromFile("hello.txt");
string s2 = ReadFromFile("fail.txt");
string s3 = ReadFromFile("fail.txt");

if (s1 != null)
{
    Console.WriteLine(s1.ToUpper());
}

if (s2 != null)
{
    Console.WriteLine(s2.ToUpper());
}
if (s3 != null)
{
    Console.WriteLine(s3.ToUpper());
}
