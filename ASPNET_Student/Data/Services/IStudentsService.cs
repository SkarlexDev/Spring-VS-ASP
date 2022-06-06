namespace ASPNET_Student.Data.Services
{
    public interface IStudentsService
    {
        List<Student> GetAll();
        Student GetById(int id);
        Student GetByEmail(string email);
        void Add(Student student);
        Student Update(int id, Student newStudent);
        void Delete(int id);

    }
}
