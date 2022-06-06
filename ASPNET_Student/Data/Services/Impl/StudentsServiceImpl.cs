namespace ASPNET_Student.Data.Services.Impl
{
    public class StudentsServiceImpl : IStudentsService
    {
        private readonly ApplicationDbContext _context;
        public StudentsServiceImpl(ApplicationDbContext context)
        {
            _context = context;
        }
        public void Add(Student student)
        {
            _context.students.Add(student);
            _context.SaveChanges();
        }

        public void Delete(int id)
        {
            var result = _context.students.FirstOrDefault(r => r.Id == id);
#pragma warning disable CS8604 // Possible null reference argument.
            _context.students.Remove(result);
#pragma warning restore CS8604 // Possible null reference argument.
            _context.SaveChanges();
        }

        public List<Student> GetAll()
        {
            var result = _context.students.ToList();
            return result;
        }

        public Student GetByEmail(string email)
        {
            var result = _context.students.FirstOrDefault(r => r.Email == email);
            return result;
        }

        public Student GetById(int id)
        {
            var result = _context.students.FirstOrDefault(r => r.Id == id);
#pragma warning disable CS8603 // Possible null reference return.
            return result;
#pragma warning restore CS8603 // Possible null reference return.
        }

        public Student Update(int id, Student newStudent)
        {

            _context.Update(newStudent);
            _context.SaveChanges();
            return newStudent;
        }
    }
}
